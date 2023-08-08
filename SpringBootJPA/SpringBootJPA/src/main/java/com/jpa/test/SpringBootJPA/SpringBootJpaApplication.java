package com.jpa.test.SpringBootJPA;

import com.jpa.test.SpringBootJPA.Model.User;
import com.jpa.test.SpringBootJPA.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = new User();
		user.setId(1);
		user.setCity("HYD");
		user.setName("karthik");

		User user1 = userRepository.save(user);
		System.out.println(user1);
	}

}
