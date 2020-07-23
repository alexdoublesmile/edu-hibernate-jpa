package edu.plohoy.spitter.api.service;

import edu.plohoy.spitter.api.domain.Spitter;

import java.util.List;

public interface SpitterService {
    void addSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
    void updateSpitter(Spitter spitter, long id);
    void deleteSpitter(long id);
    List<Spitter> getAllSpitters();
}
