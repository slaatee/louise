package com.louise.osteo.controller;

import com.louise.osteo.exception.PresentationNotFoundException;
import com.louise.osteo.model.Presentation;
import com.louise.osteo.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PresentationController {


    @Autowired
    PresentationRepository presentationRepository;

    @GetMapping("/presentation")
    public List<Presentation> getAllPresentation() {
        return presentationRepository.findAll();
    }


    @PostMapping("/presentation")
    public Presentation createPresentation(@Valid @RequestBody Presentation presentation) {

        return presentationRepository.save(presentation);

    }

    // Get a Single Note
    @GetMapping("/presentation/{id}")
    public Presentation getPresentationById(@PathVariable(value = "id") int id) throws PresentationNotFoundException {
        return presentationRepository.findById(id)
                .orElseThrow(() -> new PresentationNotFoundException(id));
    }


    @PutMapping("/presentation/{id}")
    public Presentation updatePresentation(@PathVariable(value = "id") int id,
                                 @RequestBody Presentation presentationDetails) throws PresentationNotFoundException {

        Presentation presentation = presentationRepository.findById(id)
                .orElseThrow(() -> new PresentationNotFoundException(id));
        presentation.setTitre(presentation.getTitre());
        presentation.setSoustitre(presentation.getSoustitre());
        presentation.setTexte(presentation.getTexte());
        presentation.setPhoto(presentation.getPhoto());

        return presentationRepository.save(presentation);


    }

    // Delete a Note
    @DeleteMapping("/presentation/{id}")
    public ResponseEntity<?> deletePresentation(@PathVariable(value = "id") int id) throws PresentationNotFoundException {
        Presentation presentation = presentationRepository.findById(id)
                .orElseThrow(() -> new PresentationNotFoundException(id));

        presentationRepository.delete(presentation);

        return ResponseEntity.ok().build();
    }
}