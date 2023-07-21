package fr.fms.security.service;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import fr.fms.security.repo.AppRoleRepository;
import fr.fms.security.repo.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service @Transactional @Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * méthode permettant de suavegarder un nouvel utilisateur
     * @param user l'utilisateur à enregistrer
     * @return renvoie la méthode saveUser avec l'objet utilisateuer à sauvegarder
     */
    @Override
    public AppUser saveUser(AppUser user) {
        String hasPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hasPW);
        log.info("Sauvegarde d'un nouvel utilisateur en base");

        return appUserRepository.save(user);
    }

    /**
     * méthode permettant de sauvegarder un rôle
     * @param role le rôle à sauvegarder
     * @return
     */
    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Sauvegarde d'un rôle en base");
        return appRoleRepository.save(role);
    }

    /**
     * méthode permettant d'ajouter un rôle à un utilisateur
     * @param username le nom de l'utilisateur
     * @param rolename le rôle à assigner
     */
    @Override
    public void addRoleToUser(String username, String rolename) {
        AppRole role = appRoleRepository.findByRolename(rolename);
        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().add(role);
        log.info("Association d'un rôle à un utilisateur");

    }

    /**
     * méthode permettant de récupérer un utilisateur par son nom
     * @param username le nom de l'utilisateur
     * @return
     */
    @Override
    public AppUser findUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    /**
     * méthode permettant de récupérer la liste des utilisateurs
     * @return la liste des utilisatreurs.
     */
    @Override
    public ResponseEntity<List<AppUser>> listUsers() {
        return ResponseEntity.ok().body(appUserRepository.findAll());
    }

    /**
     * méthode permettant de récupérer une liste de rôles
     * @return la liste des rôles récupérés.
     */
    @Override
    public Collection<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }


}
