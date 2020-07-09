package edu.plohoy.spitter.api.business;

import edu.plohoy.spitter.api.business.service.SpitterService;
import edu.plohoy.spitter.api.domain.Spitter;

public class ServiceFacade {
    private SpitterService spitterService;

    public void setSpitterService(SpitterService spitterService) {
        this.spitterService = spitterService;
    }


    public void addSpitter(Spitter spitter) {
        spitterService.addSpitter(spitter);
    }

    public Spitter getSpitterById(long id) {
        return spitterService.getSpitterById(id);
    }

    public void updateSpitter(Spitter spitter, long id) {
        spitterService.updateSpitter(spitter, id);
    }

    public void deleteSpitter(long id) {
        spitterService.deleteSpitter(id);
    }
}
