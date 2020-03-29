package io.hspx.petclinic.services.map;

import io.hspx.petclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    final String lastName = "Pramanik";
    OwnerServiceMap ownerServiceMap;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Long id = null;

        Owner owner3 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner3);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void notFoundByLastName() {
        Owner owner = ownerServiceMap.findByLastName("foobar");

        assertNull(owner);
    }
}