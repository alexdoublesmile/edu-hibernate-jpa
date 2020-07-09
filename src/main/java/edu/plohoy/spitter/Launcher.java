package edu.plohoy.spitter;

import edu.plohoy.spitter.api.business.ServiceDirector;
import edu.plohoy.spitter.api.business.ServiceFacade;
import edu.plohoy.spitter.api.domain.Spitter;

public class Launcher {
    private ServiceFacade facade;

    public static void main(String[] args) {
        new Launcher().execute();
    }

    private void execute() {
        facade = ServiceDirector.getInstance().createServiceFacade();

        Spitter firstSpitter = new Spitter("First Spitty");
        facade.addSpitter(firstSpitter);
        facade.getSpitterById(0);
        facade.updateSpitter(firstSpitter, 5);
        facade.deleteSpitter(5);
    }
}
