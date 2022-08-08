package co.square.shift.airplane.controller;

import co.square.shift.airplane.model.Airplane;
import co.square.shift.airplane.service.PrintSeatService;
import co.square.shift.airplane.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AirplaneController {


    private SeatService seatService;
    private PrintSeatService printSeatService;

    public AirplaneController(@Autowired  SeatService seatService, @Autowired  PrintSeatService printSeatService) {
        this.seatService = seatService;
        this.printSeatService = printSeatService;
    }


    public void initAirplane()
    {
        Airplane airplane = null;
        Scanner scanner = new Scanner(System.in);
        Airplane.Builder builder = Airplane.getBuuilder();
        boolean seatGroupFlag = true;
        boolean seatAssignFlag = false;
        int choice = 9;


        while(true)
        {
            try
            {
                printMenuConsole(seatGroupFlag,seatAssignFlag);
                choice = scanner.nextInt();
                if(choice == 9) break;

                switch (choice)
                {
                    case 1:
                        if(seatGroupFlag)
                        {
                            builder = builder.addSeatGroup(scanner);
                        }
                        break;
                    case 2:
                        if(seatGroupFlag)
                        {
                            airplane = builder.build(scanner);
                            seatService.initSeatService(airplane.getSeatGroups());
                            seatGroupFlag = false;
                            seatAssignFlag = true;
                        }
                        break;
                    case 3:
                        System.out.println("Enter number of seats to be assigned : ");
                        int seatCount = scanner.nextInt();
                        seatService.assignSeats(seatCount);
                        break;
                    case 4:
                        printSeatService.printAirplaneSeat(airplane);
                        break;
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

        }
    }

    private void printMenuConsole(boolean seatGroupFlag, boolean seatAssignFlag)
    {
        System.out.println("Follow the instruction for input --> ");
        if(seatGroupFlag)
        {
            System.out.println(" 1 Add Seat Group to Plane --> ");
            System.out.println(" 2 Launch Airplane Seat Assignment Console --> ");
        }
        else if(seatAssignFlag)
        {
            System.out.println(" 3 Assign Seats --> ");
            System.out.println(" 4 Print Airplane Seats --> ");

        }
        System.out.println(" 9 Exit the program ");
    }

}
