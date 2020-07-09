package edu.plohoy.spitter.impl.service;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import edu.plohoy.spitter.api.service.SpitterService;
import edu.plohoy.spitter.impl.dao.SpitterDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpitterServiceImplTest {

    @Test
    public void addSpitter() {
        SpitterService service = new SpitterServiceImpl();
        SpitterDao dao = new SpitterDaoImpl();
        ((SpitterServiceImpl) service).setDao(dao);

        Spitter firstSpitter = new Spitter("Spitty for Adding");
        service.addSpitter(firstSpitter);
    }

    @Test
    public void getSpitterById() {
        SpitterService service = new SpitterServiceImpl();
        SpitterDao dao = new SpitterDaoImpl();
        ((SpitterServiceImpl) service).setDao(dao);

        Spitter firstSpitter = new Spitter("Spitty from DB");
        service.getSpitterById(0);

    }

    @Test
    public void updateSpitter() {
        SpitterService service = new SpitterServiceImpl();
        SpitterDao dao = new SpitterDaoImpl();
        ((SpitterServiceImpl) service).setDao(dao);

        Spitter firstSpitter = new Spitter("Updating Spitty");
        service.updateSpitter(firstSpitter, 5);

    }

    @Test
    public void deleteSpitter() {
        SpitterService service = new SpitterServiceImpl();
        SpitterDao dao = new SpitterDaoImpl();
        ((SpitterServiceImpl) service).setDao(dao);

        Spitter firstSpitter = new Spitter("Deleted Spitty");
        service.deleteSpitter(5);

    }
}