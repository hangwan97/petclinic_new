/*
Date: August 7, 2025
Author: hangwan97
*/

package org.springframework.samples.petclinic.adoption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "adoptable_pets")
public class AdoptablePet extends BaseEntity {

    @Column(name = "species")
    private String species;

    @Column(name = "gender")
    private String gender;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "description", length = 1000)
    private String description;
    
    @Column(name = "is_adopted")
    private boolean isAdopted;
    
    public AdoptablePet() {
        // Default constructor
    }
    
    public AdoptablePet(String species, String gender, Integer age, String description) {
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.isAdopted = false;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }
}