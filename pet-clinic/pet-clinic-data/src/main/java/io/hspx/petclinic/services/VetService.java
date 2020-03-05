package io.hspx.petclinic.services;

import io.hspx.petclinic.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet pet);

    Set<Vet> findAll();
}
