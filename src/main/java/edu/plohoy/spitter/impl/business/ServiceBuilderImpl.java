package edu.plohoy.spitter.impl.business;

import edu.plohoy.spitter.api.business.ServiceBuilder;
import edu.plohoy.spitter.api.business.ServiceFacade;
import edu.plohoy.spitter.api.service.SpitterService;
import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.impl.dao.JDBCSpitterDaoImpl;
import edu.plohoy.spitter.impl.service.SpitterServiceImpl;

public class ServiceBuilderImpl implements ServiceBuilder {
    private ServiceFacade serviceFacade;

//    public void createServiceFacade() {
//        serviceFacade = new ServiceFacade();
//    }

    public SpitterService createSpitterService() {
        SpitterService spitterService = new SpitterServiceImpl();
        SpitterDao spitterDao = new JDBCSpitterDaoImpl();
        ((SpitterServiceImpl) spitterService).setDao(spitterDao);

        serviceFacade.setSpitterService(spitterService);
        return spitterService;
    }

    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }

    public void setServiceFacade(ServiceFacade serviceFacade) {
        this.serviceFacade = serviceFacade;
    }
}
