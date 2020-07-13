package edu.plohoy.spitter.impl.dao;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class HibernateSpitterDaoImpl implements SpitterDao {
    private SessionFactory sessionFactory;
    public HibernateSpitterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return currentSession().get(Spitter.class, id);
    }

    @Override
    public void updateSpitter(Spitter spitter, long id) {
        currentSession().update(spitter);
    }

    @Override
    public void deleteSpitter(long id) {
        currentSession().delete(id);
    }
}
