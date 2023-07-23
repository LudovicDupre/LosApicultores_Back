package fr.fms.security.repo;

import fr.fms.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    /**
     * méthode permettant de trouver un utilisateur par son nom
     * @param username le nom de l'utilisateur à trouver
     * @return
     */
    AppUser findByUsername(String username);
}
