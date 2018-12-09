package org.zeti.medical;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zeti.medical.repository.UserAccountRepository;
import org.zeti.medical.services.UserAccountServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalApplicationTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private UserAccountServices userAccountServices;


	@Test
	public void contextLoads()
	{
		userAccountServices.deactivateUser(1);
	}

}
