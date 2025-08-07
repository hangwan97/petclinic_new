/*
Date: August 7, 2025
Author: hangwan97
*/

package org.springframework.samples.petclinic.adoption;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface AdoptablePetRepository extends Repository<AdoptablePet, Integer> {

    /**
     * Retrieve all adoptable pets
     * @return a {@link List} of {@link AdoptablePet} objects
     */
    @Transactional(readOnly = true)
    List<AdoptablePet> findAll();
    
    /**
     * Retrieve adoptable pets by adoption status
     * @param isAdopted whether the pet has been adopted
     * @return a {@link List} of {@link AdoptablePet} objects
     */
    @Transactional(readOnly = true)
    List<AdoptablePet> findByIsAdopted(boolean isAdopted);
    
    /**
     * Retrieve an {@link AdoptablePet} by ID
     * @param id the ID to search for
     * @return the {@link AdoptablePet} if found
     */
    @Transactional(readOnly = true)
    AdoptablePet findById(Integer id);
    
    /**
     * Save an {@link AdoptablePet} to the data store
     * @param pet the entity to save
     */
    @Transactional
    void save(AdoptablePet pet);
}