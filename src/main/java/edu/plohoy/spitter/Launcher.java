package edu.plohoy.spitter;

import edu.plohoy.spitter.api.domain.Spitter;
import edu.plohoy.spitter.api.service.SpitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Launcher {

    private static List<Spitter> spitters;
    private static int spittersQuantity;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        SpitterService service = (SpitterService) ctx.getBean("service");

        System.out.println("Start Spitters Set is:");
        viewAllSpitters(service);

        Spitter newSpitter = new Spitter("Spitty", "password", "New Test Spitter Smith", "testspit@gmail.com");
        service.addSpitter(newSpitter);
        System.out.print("One Spitter was successfully added...");
        System.out.println("New Spitters Set is:");
        viewAllSpitters(service);

        Spitter spitter = service.getSpitterById(spitters.get(spittersQuantity - 1).getId());
        System.out.println(String.format("Last Spitter is: %s", spitter));
        System.out.println();

        newSpitter.setUserName("Updated Spitter");
        service.updateSpitter(newSpitter, spitters.get(spittersQuantity - 1).getId());
        spitter = service.getSpitterById(spitters.get(spittersQuantity - 1).getId());
        System.out.println(String.format("Last Spitter was updated successfully... \n Now last Spitter is: %s", spitter));
        System.out.println();

        service.deleteSpitter(spitters.get(spittersQuantity - 1).getId());
        System.out.print("Last Spitter was successfully deleted...");
        System.out.println("Result Spitters Set is:");
        viewAllSpitters(service);

    }

    private static void viewAllSpitters(SpitterService service) {
        spitters = service.getAllSpitters();
        spittersQuantity = spitters.size();
        viewSpitterList(spitters);
        System.out.println(String.format(" Quantity of Spitters: %d", spittersQuantity));
        System.out.println();
    }

    private static void viewSpitterList(List<Spitter> spitters) {
        spitters.stream()
                .forEach(Launcher::viewSpitter);
    }

    private static void viewSpitter(Spitter spitter) {
        System.out.println(
                String.format("Spitter #%d: userName - %s; password - %s; fullName - %s; e-mail - %s",
                spitter.getId(),
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail()));
    }
}
