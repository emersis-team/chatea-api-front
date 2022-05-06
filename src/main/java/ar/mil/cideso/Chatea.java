package ar.mil.cideso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Chatea extends SpringBootServletInitializer
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Chatea.class, args);
   	 	System.out.println("iniciado");
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
    	return builder.sources(Chatea.class);
    }
}