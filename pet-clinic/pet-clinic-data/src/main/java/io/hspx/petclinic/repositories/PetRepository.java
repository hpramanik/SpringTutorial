package io.hspx.petclinic.repositories;

import io.hspx.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
