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

    @Override
    public AppUser saveUser(AppUser user) {
        String hasPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hasPW);
        log.info("Sauvegarde d'un nouvel utilisateur en base");

        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Sauvegarde d'un rôle en base");
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppRole role = appRoleRepository.findByRolename(rolename);
        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().add(role);
        log.info("Association d'un rôle à un utilisateur");

    }

    @Override
    public AppUser findUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<List<AppUser>> listUsers() {
        return ResponseEntity.ok().body(appUserRepository.findAll());
    }

    @Override
    public Collection<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }


}
