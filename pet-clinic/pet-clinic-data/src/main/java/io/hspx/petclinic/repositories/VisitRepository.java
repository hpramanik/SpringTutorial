package io.hspx.petclinic.repositories;

import io.hspx.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
