package edu.plohoy.spitter.impl.dao;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;

import javax.persistence.EntityManager;
import java.util.List;

public class JPASpitterDaoImpl implements SpitterDao {
    private static final String RECENT_SPITTLES =
            "SELECT s FROM Spittle s";
    private static final String ALL_SPITTERS =
            "SELECT s FROM Spitter s";
    private static final String SPITTER_FOR_USERNAME =
"SELECT s FROM Spitter s WHERE s.username = :username";
    private static final String SPITTLES_BY_USERNAME =
            "SELECT s FROM Spittle s WHERE s.spitter.username = :username";

    private EntityManager em;

    @Override
    public void addSpitter(Spitter spitter) {
        em.persist(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return em.find(Spitter.class, id);
    }

    @Override
    public void updateSpitter(Spitter spitter, long id) {
        em.merge(spitter);
    }

    @Override
    public void deleteSpitter(long id) {
        em.remove(id);
    }

    @Override
    public List<Spitter> getAllSpitters() {
        return null;
    }
}
