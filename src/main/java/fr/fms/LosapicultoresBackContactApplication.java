package fr.fms;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import fr.fms.security.service.AccountService;
import fr.fms.security.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class LosapicultoresBackContactApplication implements CommandLineRunner {

    @Autowired
    AccountService accountService;

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
        generatedUserRoles();
    }
}