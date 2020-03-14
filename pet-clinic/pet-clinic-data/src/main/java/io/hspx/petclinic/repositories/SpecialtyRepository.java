package io.hspx.petclinic.repositories;

import io.hspx.petclinic.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
