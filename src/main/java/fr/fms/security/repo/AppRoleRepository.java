package fr.fms.security.repo;

import fr.fms.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    /**
     * méthode permettant de récupérer un utilisateur selon son rôle
     * @param rolename le rôle permettant la recherche
     * @return
     */
    AppRole findByRolename(String rolename);
}
