package fr.fms;


import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import fr.fms.security.service.AccountService;
import fr.fms.security.service.AccountServiceImpl;

import fr.fms.entities.Contact;
import fr.fms.repositories.CategoryRepository;
import fr.fms.repositories.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.service.ImplBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class LosapicultoresBackContactApplication implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    // folder images par default
    private static final String FOLDER = "C:\\Users\\MehdiouiM\\Desktop\\ImagesLosApiCultores\\Contact.jpg";

    @Autowired
    ImplBusiness implBusiness;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ContactRepository contactRepository;


    public static void main(String[] args) {
        SpringApplication.run(LosapicultoresBackContactApplication.class, args);
    }

    public void generatedUserRoles() {

        accountService.saveUser(new AppUser(null, "aurore", "1234", new ArrayList<>()));
        accountService.saveUser(new AppUser(null, "alex", "1234", new ArrayList<>()));
        accountService.saveUser(new AppUser(null, "guillaume", "1234", new ArrayList<>()));
        accountService.saveUser(new AppUser(null, "sam", "1234", new ArrayList<>()));
        accountService.saveUser(new AppUser(null, "ayyoub", "1234", new ArrayList<>()));
        accountService.saveUser(new AppUser(null, "ludo", "1234", new ArrayList<>()));
        accountService.saveRole(new AppRole(null, "Admin"));
        accountService.saveRole(new AppRole(null, "User"));

        accountService.addRoleToUser("aurore", "Admin");
        accountService.addRoleToUser("alex", "User");
        accountService.addRoleToUser("guillaume", "User");
        accountService.addRoleToUser("sam", "User");
        accountService.addRoleToUser("ayyoub", "Admin");
        accountService.addRoleToUser("ludo", "User");

    }

    @Override
    public void run(String... args) throws Exception {
        //generateDatas();
        //implBusiness.saveCategory(new Category(null, "famille"));
        // implBusiness.saveCategory(new Category(null, "ami"));
        //implBusiness.saveCategory(new Category(null, "travail"));
        //implBusiness.saveCategory(new Category(null, "urgence"));
        //implBusiness.saveCategory(new Category(null, "default"));
        //generateDatas();
       // generatedUserRoles();
       Collection<Contact> list =  implBusiness.getContactByKeyword("mac");
       System.out.println(list);
    }

    private void generateDatas() {
        Category amis = categoryRepository.save(new Category(null, "Amis", null));
        Category divers = categoryRepository.save(new Category(null, "Divers", null));
        Category famille = categoryRepository.save(new Category(null, "Famille", null));
        Category travail = categoryRepository.save(new Category(null, "Travail", null));

        contactRepository.save(new Contact(null, "Macron", "Manu", "manumac@gmail.com", "4 rue des lois", "0120458547", FOLDER, amis));
        contactRepository.save(new Contact(null, "Sarkozy", "Nico", "nicSark75@gmail.com", "4 rue de la prison", "0545784532", FOLDER, amis));
        contactRepository.save(new Contact(null, "Johnson", "Boris", "BoJohn@free.com", "410 chemin du brexit", "0689523147", FOLDER, amis));
        contactRepository.save(new Contact(null, "Biden", "Joe", "joebid@usa.org", "150 place du pétrole", "0954783214", FOLDER, amis));
        contactRepository.save(new Contact(null, "Dupont", "Jean", "jean.dupont@example.com", "123 Rue de la Paix", "0723456789", FOLDER, divers));
        contactRepository.save(new Contact(null, "Dubois", "Marie", "marie.dubois@example.com", "456 Avenue du Soleil", "0476543210", FOLDER, divers));
        contactRepository.save(new Contact(null, "Lefebvre", "Sophie", "sophie.lefebvre@example.com", "789 Boulevard des Fleurs", "0378901234", FOLDER, divers));
        contactRepository.save(new Contact(null, "Smith", "John", "john.smith@example.com", "10 Main Street", "0234567890", FOLDER, famille));
        contactRepository.save(new Contact(null, "Johnson", "Sarah", "sarah.johnson@example.com", "20 Elm Avenue", "0487654321", FOLDER, famille));
        contactRepository.save(new Contact(null, "Brown", "Michael", "michael.brown@example.com", "30 Oak Drive", "0176543210", FOLDER, famille));
        contactRepository.save(new Contact(null, "Davis", "Emily", "emily.davis@example.com", "40 Pine Lane", "0323456789", FOLDER, famille));
        contactRepository.save(new Contact(null, "Martin", "Laura", "laura.martin@example.com", "50 Cedar Street", "0876543210", FOLDER, travail));
        contactRepository.save(new Contact(null, "Garcia", "Carlos", "carlos.garcia@example.com", "60 Maple Avenue", "0123456789", FOLDER, travail));
        contactRepository.save(new Contact(null, "Robinson", "Emma", "emma.robinson@example.com", "70 Oak Drive", "0234567890", FOLDER, travail));
        contactRepository.save(new Contact(null, "Bell", "Oliver", "oliver.bell@example.com", "80 Elm Avenue", "0687654321", FOLDER, travail));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}