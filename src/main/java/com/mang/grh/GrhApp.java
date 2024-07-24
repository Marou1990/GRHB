package com.mang.grh;

import com.mang.grh.Repositories.AutorisationRepo;
import com.mang.grh.Repositories.EmployeeRepo;
import com.mang.grh.Repositories.Registration.RoleRepository;
import com.mang.grh.Repositories.Registration.UserRepository;
import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import com.mang.grh.entities.Registration.ERole;
import com.mang.grh.entities.Registration.Role;
import com.mang.grh.entities.Registration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class GrhApp implements CommandLineRunner {
	@Autowired
	EmployeeRepo er;
	@Autowired
	AutorisationRepo ar;
	@Autowired
	RoleRepository rolerep;
	@Autowired
	UserRepository userrep;
	public static void main(String[] args) {
		SpringApplication.run(GrhApp.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		/*Employee firstemp =  new  Employee("aa", "bb", 6, "06568002", "aa@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee secondemp = new  Employee("bb", "bb", 4, "06568002", "bb@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee thirdemp =  new  Employee("cc", "cc", 5, "06568005", "cc@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee fourthemp = new  Employee("dd", "dd", 8, "06568003", "dd@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		er.save(firstemp);
		er.save(secondemp);
		er.save(fourthemp);*/





		/*ar.saveAll(Arrays.asList(
				new Autorisation(null, null, null, null, "auto ur", true, 1,firstemp)	,
				new Autorisation(null, null, null, null, "auto ur", true, 1,fourthemp),
				new Autorisation(null, null, null, null, "auto ur", true, 2,fourthemp)
				));*/

		Role roleuser = new Role(ERole.USER);
		Role roleadmin = new Role(ERole.ADMIN);

		rolerep.save(roleuser);
		rolerep.save(roleadmin);

		User user = new User();
		user.setUsername("marwen.1990");
		user.setEmail("marwen.teyeb@gmail.com");
		user.setPassword("$2a$10$ZlbJFrU3ixq912YmGBW9vuZ.KrsYHWWcE2LyZxgXgpZE/sdLpuo7u");
		user.setRoles(new HashSet<>(rolerep.findAll()));
		userrep.save(user);
		System.out.println("----------All Data saved into Database----------------------");
	}
	}

