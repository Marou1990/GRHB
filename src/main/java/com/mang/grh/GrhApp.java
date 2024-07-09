package com.mang.grh;

import com.mang.grh.Repositories.AutorisationRepo;
import com.mang.grh.Repositories.EmployeeRepo;
import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class GrhApp implements CommandLineRunner {
	@Autowired
	EmployeeRepo er;
	@Autowired
	AutorisationRepo ar;
	public static void main(String[] args) {
		SpringApplication.run(GrhApp.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		Employee firstemp =  new  Employee("aa", "bb", 6, "06568002", "aa@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee secondemp = new  Employee("bb", "bb", 4, "06568002", "bb@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee thirdemp =  new  Employee("cc", "cc", 5, "06568005", "cc@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		Employee fourthemp = new  Employee("dd", "dd", 8, "06568003", "dd@yopmail.fr", "cite khadraa", null, new Date(), "celib", true);
		er.save(firstemp);
		er.save(secondemp);
		er.save(fourthemp);
		/*ar.saveAll(Arrays.asList(
				new Autorisation(null, null, null, null, "auto ur", true, 1,firstemp)	,
				new Autorisation(null, null, null, null, "auto ur", true, 1,fourthemp),
				new Autorisation(null, null, null, null, "auto ur", true, 2,fourthemp)
				));*/
		System.out.println("----------All Data saved into Database----------------------");
	}
	}

