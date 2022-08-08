package co.square.shift.airplane;

import co.square.shift.airplane.controller.AirplaneController;
import co.square.shift.airplane.service.PrintSeatService;
import co.square.shift.airplane.model.Airplane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirplaneApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(AirplaneApplication.class, args);

        AirplaneController airplaneController = applicationContext.getBean(AirplaneController.class);
        airplaneController.initAirplane();
    }

}
