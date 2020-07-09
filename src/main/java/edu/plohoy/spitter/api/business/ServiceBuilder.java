package edu.plohoy.spitter.api.business;

import edu.plohoy.spitter.api.business.service.SpitterService;

public interface ServiceBuilder {
    void createServiceFacade();
    SpitterService createSpitterService();
    ServiceFacade getServiceFacade();
}
