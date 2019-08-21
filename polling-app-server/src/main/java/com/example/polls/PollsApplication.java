package com.example.polls;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		PollsApplication.class,
		Jsr310JpaConverters.class
})
@EnableEurekaClient
public class PollsApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);
	}
	
//	@Bean 
//	public FilterRegistrationBean<Filter> corsFilter() {
//		  UrlBasedCorsConfigurationSource source = new
//		  UrlBasedCorsConfigurationSource(); 
//		  CorsConfiguration config = new CorsConfiguration(); 
//		  config.setAllowCredentials(true);
//		  config.addAllowedOrigin("*");
//		  config.addAllowedHeader("*");
//		  config.addAllowedMethod("*"); 
//		  source.registerCorsConfiguration("/**",config); 
//		  FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source)); 
//		  bean.setOrder(0);
//		  return bean; 
//		  }
//	
}
