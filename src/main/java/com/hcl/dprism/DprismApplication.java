package com.hcl.dprism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
/**
 * Dprism Application
 * @author bikash.k
 *
 */
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
@ComponentScan({"com.hcl.dprism.*,org.thymeleaf.extras.springsecurity4"})
//@Component("com.hcl.dprism.*")
public class DprismApplication {
	
   	public static void main(String[] args) {
		SpringApplication.run(DprismApplication.class, args);
	}
   	
   	
   	@Bean
   	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec) {
   	    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
   	    templateEngine.setTemplateResolver(templateResolver);
   	    templateEngine.addDialect(sec); // Enable use of "sec"
   	    return templateEngine;
   	}	
}
