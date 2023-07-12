package fr.fms;

import fr.fms.entities.Category;
import fr.fms.service.ImplBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LosapicultoresBackContactApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LosapicultoresBackContactApplication.class, args);
	}

	@Autowired
	ImplBusiness implBusiness;

	@Override
	public void run(String... args) throws Exception {
		//implBusiness.saveCategory(new Category(null, "famille"));
		// implBusiness.saveCategory(new Category(null, "ami"));
		//implBusiness.saveCategory(new Category(null, "travail"));
		//implBusiness.saveCategory(new Category(null, "urgence"));
		//implBusiness.saveCategory(new Category(null, "default"));

	}
}
