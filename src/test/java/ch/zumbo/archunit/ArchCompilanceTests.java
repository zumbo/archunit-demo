package ch.zumbo.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeArchives.class)
class ArchCompilanceTests {

    @ArchTest
    static final ArchRule namingConventions = classes().that().resideInAnyPackage("..service..")
            .and().areNotInterfaces().should().haveSimpleNameEndingWith("Service");


    @ArchTest
    static final ArchRule enforceServiceAnnotation = classes().that().haveSimpleNameEndingWith("Service")
            .and().areNotInterfaces().should().beAnnotatedWith(Service.class);

    @ArchTest
    static final ArchRule noServicesOutsidePackage = classes().that().areAnnotatedWith(Service.class)
            .should().resideInAPackage("..service..");

    @ArchTest
    static final ArchRule noStaticBusinessFunctionOutsideUtils = methods().that().areStatic()
            .and().areDeclaredInClassesThat().resideInAPackage("..business..")
            .should().beDeclaredInClassesThat().haveSimpleNameEndingWith("Utils");

    @ArchTest
    static final ArchRule noPublicUtils = methods().that().areDeclaredInClassesThat().haveSimpleNameEndingWith("Utils").should().notBePublic();

    @ArchTest
    static final ArchRule noPublicUtils2 = classes().that().haveSimpleNameEndingWith("Utils").should().notBePublic();

    @ArchTest
    static final ArchRule dependencyCheckBusiness = noClasses().that().resideInAPackage("..business..")
            .should().dependOnClassesThat().resideInAnyPackage("..service..", "..infrastructure..");

    @ArchTest
    static final ArchRule dependencyCheckService = noClasses().that().resideInAPackage("..service..")
            .should().dependOnClassesThat().resideInAnyPackage("..infrastructure..");

    @ArchTest
    static final ArchRule layering = layeredArchitecture()
            .layer("ApplicationMain").definedBy("ch.zumbo.archunit")
            .layer("Core").definedBy("..business..")
            .layer("Service").definedBy("..service..")
            .layer("Infrastructure").definedBy("..infrastructure..")

            .whereLayer("ApplicationMain").mayNotBeAccessedByAnyLayer()
            .whereLayer("Infrastructure").mayOnlyBeAccessedByLayers("ApplicationMain")
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Infrastructure")
            .whereLayer("Core").mayOnlyBeAccessedByLayers("Service");


    @ArchTest
    static final ArchRule onion = onionArchitecture()
            .domainModels("..business..")
            .domainServices("..service..")
            .applicationServices("..service..")
            .adapter("infrastructure","..infrastructure..", "ch.zumbo.archunit");

    @ArchTest
    static final ArchRule noCyclicDependencies = slices().matching("ch.zumbo.archunit.(*)..").should().beFreeOfCycles();


}
