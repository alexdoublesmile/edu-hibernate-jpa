package edu.plohoy.spitter.impl.dao;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;

public class SpitterDaoImpl implements SpitterDao {
    public void addSpitter(Spitter spitter) {
        System.out.println(String.format("Spitter \"%s\" was added!", spitter.getName()));
    }

    public Spitter getSpitterById(long id) {
        System.out.println(String.format("Spitter with id=%d was taken!", id));
        return null;
    }

    public void updateSpitter(Spitter spitter, long id) {
        System.out.println(String.format("Spitter №%d \"%s\" will be updated to №%d!", spitter.getId(), spitter.getName(), id));
        spitter.setId(id);
        System.out.println(String.format("Spitter \"%s\" was successfully updated to №%d!", spitter.getName(), spitter.getId()));
    }

    public void deleteSpitter(long id) {
        System.out.println(String.format("Spitter №%d was deleted!", id));
    }
}
