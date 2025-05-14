package com.dataBase_JDBC;

import com.dataBase_JDBC.DAO.UserService;
import com.dataBase_JDBC.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {


	@Autowired
	private UserService userService;




	@Test
	void userTest()
	{
		User u = new User();
		u.setRollno(12);
		u.setName("Tirth Chapla");
		u.setEmail("tirth@example.com");
		u.setMobileno("9876543200");
		u.setCity("Rajkot");
		u.setCountry("India");

		int row = userService.userCreate(u);
		Assertions.assertEquals(1,row );
	}


}
