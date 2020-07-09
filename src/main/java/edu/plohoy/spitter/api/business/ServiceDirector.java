package edu.plohoy.spitter.api.business;

import edu.plohoy.spitter.impl.business.ServiceBuilderImpl;

public class ServiceDirector {

    private static ServiceDirector instance;

    private ServiceDirector(){}

    public ServiceFacade createServiceFacade() {
        ServiceBuilder builder = new ServiceBuilderImpl();

        builder.createServiceFacade();
        builder.createSpitterService();

        return builder.getServiceFacade();
    }

    public static synchronized ServiceDirector getInstance() {
        if (instance == null) {
            instance = new ServiceDirector();
        }
        return instance;
    }

}
