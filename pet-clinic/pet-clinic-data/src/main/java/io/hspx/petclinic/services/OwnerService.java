package io.hspx.petclinic.services;

import io.hspx.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}