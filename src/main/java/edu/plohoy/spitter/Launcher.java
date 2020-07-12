package edu.plohoy.spitter;

import edu.plohoy.spitter.api.business.ServiceDirector;
import edu.plohoy.spitter.api.business.ServiceFacade;
import edu.plohoy.spitter.api.domain.Spitter;
import edu.plohoy.spitter.api.service.SpitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
//    private ServiceFacade facade;

    public static void main(String[] args) {
//        new Launcher().execute();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        SpitterService service = (SpitterService) ctx.getBean("service");


        Spitter firstSpitter = new Spitter("New Spitty", "password", "New Spitter Smith", "newSpit@gmail.com");
        service.addSpitter(firstSpitter);
        System.out.println(service.getSpitterById(10));
        service.updateSpitter(firstSpitter, 10);
        System.out.println(service.getSpitterById(10));
        service.deleteSpitter(10);
        if (service.getSpitterById(10).getId() == 0) {
            System.out.println("There is no any row with this number!");
        } else {
            System.out.println(service.getSpitterById(10));
        }

//        service.updateSpitter(firstSpitter, 5);
//        service.deleteSpitter(5);

    }

//    private void execute() {
//        facade = ServiceDirector.getInstance().createServiceFacade();
//
//        Spitter firstSpitter = new Spitter("First Spitty");
//        facade.addSpitter(firstSpitter);
//        facade.getSpitterById(0);
//        facade.updateSpitter(firstSpitter, 5);
//        facade.deleteSpitter(5);
//    }
}
