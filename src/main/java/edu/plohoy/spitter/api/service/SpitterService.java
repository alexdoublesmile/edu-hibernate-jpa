package edu.plohoy.spitter.api.service;

import edu.plohoy.spitter.api.domain.Spitter;

public interface SpitterService {
    void addSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
    void updateSpitter(Spitter spitter, long id);
    void deleteSpitter(long id);
}
