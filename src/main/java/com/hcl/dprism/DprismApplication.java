package com.hcl.dprism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.hcl.dprism.dao.AppRoleDAO;
import com.hcl.dprism.service.UserDetailsServiceImpl;
import com.hcl.dprism.utils.DateConverter;
/**
 * Dprizm Application
 * @author bikash.k
 *
 */

@SpringBootApplication
@ComponentScan({"com.hcl.dprism.*,org.thymeleaf.extras.*,com.hcl.dprism.utils.*"})
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
   	 templateEngine.addDialect(new Java8TimeDialect()); 
   	    return templateEngine;
   	}
   	
  	@Bean
    public DateConverter DateConverter() {
        return new DateConverter();
    }
  	
  	@Bean
  	public UserDetailsServiceImpl UserDetailsServiceImpl() {
  		return new UserDetailsServiceImpl();
  	}
  	
 	@Bean
  	public AppRoleDAO AppRoleDAO() {
  		return new AppRoleDAO();
  	}
  	
   	
  /* 	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver,Java8TimeDialect jd) {
   	    SpringTemplateEngine engine = new SpringTemplateEngine();
   	    engine.addDialect(new Java8TimeDialect());
   	    engine.setTemplateResolver(templateResolver);
   	    return engine;
   	}*/
}
