package ch.zumbo.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ArchCompilanceTests {

    @Test
    void testArchCompilance() {
        JavaClasses importedClasses = new ClassFileImporter().importClasspath();

        ArchRule myRule = classes().that().haveSimpleNameContaining("Service")
                .and().areNotInterfaces().should().beAnnotatedWith(Service.class);
        myRule.check(importedClasses);
    }
}
