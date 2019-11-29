package ch.zumbo.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeArchives.class)
class ArchCompilanceTestsSimple {

    @ArchTest
    static final ArchRule archCompilance = classes().that().haveSimpleNameContaining("Service")
            .and().areNotInterfaces().should().beAnnotatedWith(Service.class);

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
}
