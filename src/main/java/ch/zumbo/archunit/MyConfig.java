package ch.zumbo.archunit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ch.zumbo.archunit")
class MyConfig {
}
