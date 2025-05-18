package com.Spring_JPA;

import com.Spring_JPA.entity.Product;
import com.Spring_JPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}


	//✅ aaya @AutoWired Kar va thi
	// ProductRepository no ,
	// 		1.automatic class bani jase
	//      2.Automatioc Badihi method implement thi jase
	//this feature is provided by ❤️ Spring Boot

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception
	{
		Product p1 = new Product();

		p1.setId(1);
		p1.setName("Hp victus 123");
		p1.setLive(true);

		productRepository.save(p1);
	}
}
