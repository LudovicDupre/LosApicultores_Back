package fr.fms.security.controllers;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import fr.fms.security.service.AccountService;
import fr.fms.security.service.AccountServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AccountRestController {
     @Autowired
    AccountServiceImpl accountService;
     @GetMapping("/users")
    ResponseEntity<List<AppUser>> getUsers() { return this.accountService.listUsers(); }
     @PostMapping("/users")
    public AppUser postUser(@RequestBody AppUser user) { return this.accountService.saveUser(user); }
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
