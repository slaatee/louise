package com.louise.osteo.controller;
import com.louise.osteo.exception.CategorieNotFoundException;
import com.louise.osteo.model.Categorie;
import com.louise.osteo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;

    @GetMapping("/categorie")
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @PostMapping("/categorie")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {

        return categorieRepository.save(categorie);

    }

    // Get a Single Note
    @GetMapping("/categorie/{id}")
    public Categorie getCategorieById(@PathVariable(value = "id") int id) throws CategorieNotFoundException {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));
    }

    @PutMapping("/categorie{id}")
    public Categorie updateCategorie(@PathVariable(value = "id") int id,
                                  @RequestBody Categorie categorieDetails) throws CategorieNotFoundException {

        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));
       categorie.setNom(categorie.getNom());
       categorie.setTexte(categorie.getTexte());

        return categorieRepository.save(categorie);
    }

    // Delete a Note
    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable(value = "id") int id) throws CategorieNotFoundException {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));

        categorieRepository.delete(categorie);
        return ResponseEntity.ok().build();
    }
}
