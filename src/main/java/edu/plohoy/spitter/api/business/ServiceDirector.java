package edu.plohoy.spitter.api.business;

public class ServiceDirector {

//    private static ServiceDirector instance;
    private ServiceBuilder builder;

    private ServiceDirector(){}

    public ServiceFacade createServiceFacade() {
//        builder = new ServiceBuilderImpl();

//        builder.createServiceFacade();
        builder.createSpitterService();

        return builder.getServiceFacade();
    }

//    public static synchronized ServiceDirector getInstance() {
//        if (instance == null) {
//            instance = new ServiceDirector();
//        }
//        return instance;
//    }

    public void setBuilder(ServiceBuilder builder) {
        this.builder = builder;
    }

}
