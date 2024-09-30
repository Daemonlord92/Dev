package org.blitmatthew;

import org.blitmatthew.vehicle.Car;
import org.blitmatthew.vehicle.Engine;
import org.blitmatthew.vehicle.V6Engine;
import org.blitmatthew.vehicle.V8Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        Engine engine1 = new V6Engine();
//        Engine engine2 = new V8Engine();
        Car car3 = new Car(engine1);
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Car car =   context.getBean("carV6", Car.class);//new Car(context.getBean("v6Engine", V6Engine.class));
        Car car1 = new Car(context.getBean("v8Engine", V8Engine.class));

        car.start();

        car1.start();
    }
}