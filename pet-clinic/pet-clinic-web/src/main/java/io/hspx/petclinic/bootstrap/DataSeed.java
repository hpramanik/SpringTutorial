package io.hspx.petclinic.bootstrap;

import io.hspx.petclinic.models.Owner;
import io.hspx.petclinic.models.Vet;
import io.hspx.petclinic.services.OwnerService;
import io.hspx.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeed implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataSeed(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Himangshu");
        owner1.setLastName("Pramanik");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ravi");
        owner2.setLastName("Prakash");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
