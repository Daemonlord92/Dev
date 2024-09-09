package org.blitmatthew;

import org.blitmatthew.vehicle.Car;
import org.blitmatthew.vehicle.Engine;
import org.blitmatthew.vehicle.V6Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Engine engine = new V6Engine();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        /*Car car = new Car(context.getBean("v6Engine", V6Engine.class));
        Car car2 = new Car(context.getBean("v6Engine", V6Engine.class));*/
        Car car3 = context.getBean("carV6", Car.class);

        /*car.start();*/
        car3.start();
    }
}