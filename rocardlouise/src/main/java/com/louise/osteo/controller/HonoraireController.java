package com.louise.osteo.controller;
import com.louise.osteo.exception.HonoraireNotFoundException;
import com.louise.osteo.model.Honoraire;
import com.louise.osteo.repository.HonoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class HonoraireController {

    @Autowired
    HonoraireRepository honoraireRepository;

    @GetMapping("/honoraire")
    public List<Honoraire> getAllHonoraire() {
        return honoraireRepository.findAll();
    }

    @PostMapping("/honoraire")
    public Honoraire createHonoraire(@Valid @RequestBody Honoraire honoraire) {

        return honoraireRepository.save(honoraire);

    }

    // Get a Single Note
    @GetMapping("/honoraire/{id}")
    public Honoraire getHonoraireById(@PathVariable(value = "id") int id) throws HonoraireNotFoundException {
        return honoraireRepository.findById(id)
                .orElseThrow(() -> new HonoraireNotFoundException(id));
    }

    @PutMapping("/honoraire/{id}")
    public Honoraire updateHonoraire(@PathVariable(value = "id") int id,
                               @RequestBody Honoraire honoraireDetails) throws HonoraireNotFoundException {

        Honoraire honoraire = honoraireRepository.findById(id)
                .orElseThrow(() -> new HonoraireNotFoundException(id));
        honoraire.setTexte(honoraire.getTexte());
        honoraire.setPrix(honoraire.getPrix());

        return honoraireRepository.save(honoraire);
    }

    // Delete a Note
    @DeleteMapping("/honoraire/{id}")
    public ResponseEntity<?> deleteHonoraire(@PathVariable(value = "id") int id) throws HonoraireNotFoundException {
        Honoraire honoraire = honoraireRepository.findById(id)
                .orElseThrow(() -> new HonoraireNotFoundException(id));

        honoraireRepository.delete(honoraire);
        return ResponseEntity.ok().build();
    }
}
