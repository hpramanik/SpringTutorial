package io.hspx.petclinic.repositories;

import io.hspx.petclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
