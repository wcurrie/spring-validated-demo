package x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
public class X {

    @Bean
    public MethodValidationPostProcessor postProcessor() {
        return new MethodValidationPostProcessor();
    }

    public static void main(String[] args) {
        SpringApplication.run(X.class, args);
    }
}
