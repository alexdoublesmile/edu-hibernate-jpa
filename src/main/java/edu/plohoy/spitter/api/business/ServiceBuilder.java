package edu.plohoy.spitter.api.business;

import edu.plohoy.spitter.api.business.ServiceFacade;
import edu.plohoy.spitter.api.service.SpitterService;

public interface ServiceBuilder {
//    void createServiceFacade();
    SpitterService createSpitterService();
    ServiceFacade getServiceFacade();
}
