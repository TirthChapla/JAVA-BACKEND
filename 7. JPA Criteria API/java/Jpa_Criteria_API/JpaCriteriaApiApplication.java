package Jpa_Criteria_API;

import Jpa_Criteria_API.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpaCriteriaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaCriteriaApiApplication.class, args);
	}

	@Autowired
	ProductDao productDao;


	@Override
	public void run(String... args) throws Exception
	{
		// productDao.getProduct();

		System.out.println("Join Betwn Product n Category");
		productDao.getJoinQuery();
	}
}
