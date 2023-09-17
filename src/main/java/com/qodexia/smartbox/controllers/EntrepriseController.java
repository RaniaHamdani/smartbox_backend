package com.qodexia.smartbox.controllers;

import com.qodexia.smartbox.mapper.EntrepriseMapper;
import com.qodexia.smartbox.models.EntrepriseDto;
import com.qodexia.smartbox.services.api.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    private final EntrepriseService entrepriseService;
    @Autowired
    private final EntrepriseMapper entrepriseMapper;

    public EntrepriseController(EntrepriseService entrepriseService, EntrepriseMapper entrepriseMapper) {
        this.entrepriseService = entrepriseService;
        this.entrepriseMapper = entrepriseMapper;
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<EntrepriseDto> getEntrepriseById(@PathVariable Long id) {
        EntrepriseDto entrepriseDto = entrepriseService.getEntrepriseById(id);
        if (entrepriseDto != null) {
            return ResponseEntity.ok(entrepriseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<EntrepriseDto> getEntrepriseByUserId(@PathVariable Long userId) {
        EntrepriseDto entrepriseDto = entrepriseService.getEntrepriseByUserId(userId);
        if (entrepriseDto != null) {
            return ResponseEntity.ok(entrepriseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EntrepriseDto> createEntreprise(@RequestBody @Valid EntrepriseDto entrepriseDto) {
        EntrepriseDto savedEntrepriseDto = entrepriseService.createEntreprise(entrepriseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntrepriseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrepriseDto> updateEntreprise(
            @PathVariable Long id, @RequestBody @Valid EntrepriseDto entrepriseDto) {
        entrepriseDto.setId(id);
        EntrepriseDto updatedEntrepriseDto = entrepriseService.updateEntreprise(entrepriseDto);
        if (updatedEntrepriseDto != null) {
            return ResponseEntity.ok(updatedEntrepriseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Long id) {
        entrepriseService.deleteEntrepriseById(id);
        return ResponseEntity.noContent().build();
    }
}

