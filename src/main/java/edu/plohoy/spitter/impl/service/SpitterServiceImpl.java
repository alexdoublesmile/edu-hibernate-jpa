package edu.plohoy.spitter.impl.service;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import edu.plohoy.spitter.api.service.SpitterService;

public class SpitterServiceImpl implements SpitterService {
    private SpitterDao dao;

    public void addSpitter(Spitter spitter) {
        dao.addSpitter(spitter);
    }

    public Spitter getSpitterById(long id) {
        return dao.getSpitterById(id);
    }

    public void updateSpitter(Spitter spitter, long id) {
        dao.updateSpitter(spitter, id);
    }

    public void deleteSpitter(long id) {
        dao.deleteSpitter(id);
    }

    public void setDao(SpitterDao dao) {
        this.dao = dao;
    }
}
