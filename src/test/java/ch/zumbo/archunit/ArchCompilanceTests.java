package ch.zumbo.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeArchives.class)
class ArchCompilanceTests {

    @ArchTest
    static final ArchRule namingConventions = classes().that().resideInAnyPackage("..service..")
            .and().areNotInterfaces().should().haveSimpleNameEndingWith("Service");
}
