package com.tw.config;

import com.tw.db.UserDAO;
import com.tw.model.User;
import com.tw.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages="com.tw")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setCache(true);
		resolver.setSuffix(".ftl");
		return resolver;
	}

    @Bean
    public FreeMarkerConfigurer getViewConfigurer(){
        FreeMarkerConfigurer configurer =new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;

    }

    @Bean
    public DriverManagerDataSource getDataSource(){
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/test","root","");

    }

    @Bean
    public SessionFactory getSessionFactory(){
        SessionFactory concreteSessionFactory;

        try {
            Properties prop= new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "");
            prop.setProperty("hibernate.show_sql","true");
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect") ;
            prop.setProperty("hibernate.current_session_context_class","org.hibernate.context.internal.ThreadLocalSessionContext");

            concreteSessionFactory = new AnnotationConfiguration()
                    .addPackage("com.tw")
                    .addPackage("com.tw.model")
                    .addProperties(prop)
                    .addAnnotatedClass(UserDAO.class)
                    .addAnnotatedClass(UserService.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory() ;
            return concreteSessionFactory;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------should not reach here--------------");
        return null;
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
}
