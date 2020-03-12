package io.hspx.petclinic.bootstrap;

import io.hspx.petclinic.models.*;
import io.hspx.petclinic.services.OwnerService;
import io.hspx.petclinic.services.PetTypeService;
import io.hspx.petclinic.services.SpecialtyService;
import io.hspx.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSeed implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataSeed(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Himangshu");
        owner1.setLastName("Pramanik");
        owner1.setAddress("North 24 Parganas");
        owner1.setCity("Kolkata");
        owner1.setTelephone("9007294751");

        Pet pet1 = new Pet();
        pet1.setName("Nimo");
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now().minusYears(2));

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ravi");
        owner2.setLastName("Prakash");
        owner2.setAddress("Ranga Reddy District");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("8142222404");

        Pet pet2 = new Pet();
        pet2.setName("Fiona");
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now().minusMonths(5));

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
