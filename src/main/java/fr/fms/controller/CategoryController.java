package fr.fms.controller;



import fr.fms.entities.Category;
import fr.fms.service.ImplBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private ImplBusiness implBusiness;

    /**
     * Méthode en GET récupérant toutes les catégories en BDD
     * @return une liste de catégories
     */
    @GetMapping("/category")
    public List<Category> allCategories() {return implBusiness.getCategories();}

    /**
     * méthode qui permet de renvoyer sur une page selon un id de category.
     * @param cat
     * @return
     */
    @PostMapping("/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category cat) {
        Category category = implBusiness.saveCategory(cat);
        if(Objects.isNull(category)) {  return ResponseEntity.noContent().build();  }
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(category.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * méthode DELETE permettant de supprimer une catégory
     * @param id l'identifiant de la catégorie à supprimer
     */
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) { implBusiness.deleteCategory(id);  }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")Long id) {
        Optional<Category> category = implBusiness.readCategory(id);
        if(category.isPresent()) {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }
        return null;
    }

}
