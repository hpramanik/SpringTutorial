package io.hspx.petclinic.services.map;

import io.hspx.petclinic.models.Visit;
import io.hspx.petclinic.services.springDataJPA.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if (object != null || object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
