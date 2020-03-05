package io.hspx.petclinic.services;

import io.hspx.petclinic.models.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}