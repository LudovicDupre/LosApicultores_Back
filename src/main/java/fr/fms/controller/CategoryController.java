package fr.fms.controller;

import fr.fms.entities.Category;
import fr.fms.service.ImplBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ImplBusiness implBusiness;

    @GetMapping("/category")
    public List<Category> allCategories() {return implBusiness.getCategories();}



}
