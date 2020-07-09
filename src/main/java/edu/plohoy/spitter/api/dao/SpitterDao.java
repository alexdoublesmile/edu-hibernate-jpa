package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Spitter;

public interface SpitterDao {
    void addSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
    void updateSpitter(Spitter spitter, long id);
    void deleteSpitter(long id);
}
