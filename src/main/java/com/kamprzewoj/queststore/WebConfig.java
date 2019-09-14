package com.kamprzewoj.queststore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}
//}



@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/api/**")
				.allowedOrigins("**")
//				.allowedOrigins("http://localhost")
//				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedMethods("**")
//				.allowedHeaders("header1", "header2", "header3")
				.allowedHeaders("**")
//				.exposedHeaders("header1", "header2")
				.exposedHeaders("**")
				.allowCredentials(true).maxAge(3600);

		// Add more mappings...
	}
}