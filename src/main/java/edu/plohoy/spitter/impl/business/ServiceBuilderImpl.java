package edu.plohoy.spitter.impl.business;

import edu.plohoy.spitter.api.business.ServiceBuilder;
import edu.plohoy.spitter.api.business.ServiceFacade;
import edu.plohoy.spitter.api.business.service.SpitterService;
import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.impl.business.service.SpitterServiceImpl;
import edu.plohoy.spitter.impl.dao.SpitterDaoImpl;

public class ServiceBuilderImpl implements ServiceBuilder {
    private ServiceFacade serviceFacade;

    public void createServiceFacade() {
        serviceFacade = new ServiceFacade();
    }

    public SpitterService createSpitterService() {
        SpitterService spitterService = new SpitterServiceImpl();
        SpitterDao spitterDao = new SpitterDaoImpl();
        ((SpitterServiceImpl) spitterService).setDao(spitterDao);

        serviceFacade.setSpitterService(spitterService);
        return spitterService;
    }

    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }
}
