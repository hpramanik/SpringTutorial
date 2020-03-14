package io.hspx.petclinic.repositories;

import io.hspx.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
