package ch.zumbo.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ArchCompilanceTestsJUnitStyle {

    private static JavaClasses importedClasses;

    @BeforeAll
    static void loadClasses() {
        importedClasses = new ClassFileImporter().importClasspath();
    }

    @Test
    void testNamingConventions() {
        ArchRule myRule = classes().that().resideInAnyPackage("..service..")
                .and().areNotInterfaces().should().haveSimpleNameEndingWith("Service");
        myRule.check(importedClasses);
    }
}
