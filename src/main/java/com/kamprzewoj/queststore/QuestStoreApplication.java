package com.kamprzewoj.queststore;

import com.kamprzewoj.queststore.model.UserClassModel;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class QuestStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestStoreApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserClassRepository repository) {
		String[][] data = {
				{"Beginners", "http://bleble3.com"},
				{"Medium", "http://bleble2.com"},
				{"Advance", "http://bleble1.com"},
		};
		return args -> {
			UserClassModel userClassModel1 = new UserClassModel(data[0][0], data[0][1]);
			UserClassModel userClassModel2 = new UserClassModel(data[1][0], data[1][1]);
			UserClassModel userClassModel3 = new UserClassModel(data[2][0], data[2][1]);
			repository.save(userClassModel1);
			repository.save(userClassModel2);
			repository.save(userClassModel3);
			System.out.println(userClassModel1);
			System.out.println(userClassModel2);
			System.out.println(userClassModel3);
		};
	}


}
