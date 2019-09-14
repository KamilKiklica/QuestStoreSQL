package com.kamprzewoj.queststore;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class QuestStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestStoreApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
			}
		};
	}

//	@Bean
//	ApplicationRunner init(UserClassRepository repository) {
//		String[][] data = {
//				{"Beginners", "http://bleble3.com"},
//				{"Medium", "http://bleble2.com"},
//				{"Advance", "http://bleble1.com"},
//		};
//		return args -> {
//			UserClass userClassModel1 = new UserClass(data[0][0], data[0][1]);
//			UserClass userClassModel2 = new UserClass(data[1][0], data[1][1]);
//			UserClass userClassModel3 = new UserClass(data[2][0], data[2][1]);
//			repository.save(userClassModel1);
//			repository.save(userClassModel2);
//			repository.save(userClassModel3);
//			System.out.println(userClassModel1);
//			System.out.println(userClassModel2);
//			System.out.println(userClassModel3);
//		};
//	}


}
