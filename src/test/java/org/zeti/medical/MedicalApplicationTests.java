package org.zeti.medical;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zeti.medical.repository.UserAccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalApplicationTests {

	@Autowired
	private UserAccountRepository userAccountRepository;


	@Test
	public void contextLoads()
	{
		boolean isPasswordExist = userAccountRepository.existsByPassword("Password");
		if(isPasswordExist)
		{
			System.out.println("Password already exist: " + isPasswordExist);
		}
	}

}
