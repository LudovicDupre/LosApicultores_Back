package fr.fms.security.service;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username, String rolename);
    public AppUser findUserByUsername(String username);
    ResponseEntity<List<AppUser>> listUsers();

    /**
     * méthode permettant de récupérer une liste de rôles
     * @return renvoie une liste des rôles
     */
    Collection<AppRole> getAllRoles();
}
