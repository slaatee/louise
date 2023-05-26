package com.louise.osteo.controller;
import com.louise.osteo.exception.SeanceNotFoundException;
import com.louise.osteo.model.Seance;
import com.louise.osteo.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SeanceController {

    @Autowired
    SeanceRepository seanceRepository;

    @GetMapping("/seance")
    public List<Seance> getAllSeance() {return seanceRepository.findAll();}

    @PostMapping("/seance")
    public Seance createSeance(@Valid @RequestBody Seance seance) {

        return seanceRepository.save(seance);

    }
    // Get a Single Note
    @GetMapping("/seance/{id}")
    public Seance getSeanceById(@PathVariable(value = "id") int id) throws SeanceNotFoundException {
        return seanceRepository.findById(id)
                .orElseThrow(() -> new SeanceNotFoundException(id));
    }

    @PutMapping("/seance/{id}")
    public  Seance updateSeance(@PathVariable(value = "id") int id,
    @RequestBody Seance seanceDetails) throws SeanceNotFoundException {

        Seance seance = seanceRepository.findById(id)
                .orElseThrow(() -> new SeanceNotFoundException(id));
        seance.setTitre(seance.getTitre());
        seance.setTexte(seance.getTexte());
        seance.setColor(seance.getColor());
        seance.setNumero(seance.getNumero());
        seance.setIcon(seance.getIcon());

        return seanceRepository.save(seance);
    }
    // Delete a Note
    @DeleteMapping("/seance/{id}")
    public ResponseEntity<?> deleteSeance(@PathVariable(value = "id") int id) throws SeanceNotFoundException {
        Seance seance = seanceRepository.findById(id)
                .orElseThrow(() -> new SeanceNotFoundException(id));

        seanceRepository.delete(seance);
        return ResponseEntity.ok().build();
    }

}
