package edu.plohoy.spitter.impl.service;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import edu.plohoy.spitter.api.service.SpitterService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class SpitterServiceImpl implements SpitterService {
    private SpitterDao dao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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

    @Override
    public List<Spitter> getAllSpitters() {
        return dao.getAllSpitters();
    }

    public void setDao(SpitterDao dao) {
        this.dao = dao;
    }
}
