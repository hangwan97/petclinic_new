/*
Date: August 7, 2025
Author: hangwan97
*/

package org.springframework.samples.petclinic.adoption;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adoption")
public class AdoptionController {

    private final AdoptablePetRepository adoptablePetRepository;

    public AdoptionController(AdoptablePetRepository adoptablePetRepository) {
        this.adoptablePetRepository = adoptablePetRepository;
    }

    @GetMapping()
    public String listAdoptablePets(Map<String, Object> model) {
        List<AdoptablePet> adoptablePets = this.adoptablePetRepository.findAll();
        model.put("adoptablePets", adoptablePets);
        return "adoption/adoptionList";
    }
    
    @PostMapping("/{petId}/adopt")
    public String adoptPet(@PathVariable("petId") int petId) {
        AdoptablePet pet = this.adoptablePetRepository.findById(petId);
        if (pet != null) {
            pet.setAdopted(true);
            this.adoptablePetRepository.save(pet);
        }
        return "redirect:/adoption";
    }
}