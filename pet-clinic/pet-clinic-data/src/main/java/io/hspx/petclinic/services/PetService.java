package io.hspx.petclinic.services;

import io.hspx.petclinic.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
