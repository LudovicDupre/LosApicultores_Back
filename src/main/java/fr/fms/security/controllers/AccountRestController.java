package fr.fms.security.controllers;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import fr.fms.security.service.AccountService;
import fr.fms.security.service.AccountServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AccountRestController {
     @Autowired
    AccountServiceImpl accountService;
     @GetMapping("/users")
    ResponseEntity<List<AppUser>> getUsers() { return this.accountService.listUsers(); }
     @PostMapping("/users")
    public AppUser postUser(@RequestBody AppUser user) {
         AppUser user1 = this.accountService.saveUser(user);
         accountService.addRoleToUser(user1.getUsername(), "User");
         return user1;
     }


    @PostMapping("/role")
    public AppRole postRole(@RequestBody AppRole role) { return this.accountService.saveRole(role); }
    @PostMapping("/roleUser")
    public void postRoleToUser(@RequestBody UserRoleForm userRoleForm) {
         accountService.addRoleToUser(userRoleForm.getUsername(), userRoleForm.getRolename());
    }

}
@Data
class UserRoleForm {
    private String username;
    private String rolename;
}
