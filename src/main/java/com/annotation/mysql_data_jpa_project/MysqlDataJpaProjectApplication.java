package com.annotation.mysql_data_jpa_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.annotation.mysql_data_jpa_project.repository.UserRepository;
import com.annotation.mysql_data_jpa_project.service.Tester;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MysqlDataJpaProjectApplication {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    Tester tester;

    public static void main(String[] args) {
        SpringApplication.run(MysqlDataJpaProjectApplication.class, args);

        /* try {
            int n1 = 10;
            int n2 = 0;

            int result = n1 / n2;

            System.out.println("Result: " + result);

        } catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			
        }
 */
        System.out.println("Application started successfully!");

    }

    @PostConstruct
    public void init() {

        /* User user = new User();
		user.setName("Sagar");
		user.setEmail("s@gmail.com");
		//user.setAddress("Pune");
		user.setPassword("123456");
		user.setPhoneNumber("1234567890");
		userRepository.save(user);
		
		System.out.println("User saved: " + user.getName() + ", Email: " + user.getEmail() + ", Address: " + user.getAddress() + ", Phone: " + user.getPhoneNumber());
         */
    }

}
