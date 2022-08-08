package co.square.shift.airplane.service;

import co.square.shift.airplane.model.SeatGroup;
import co.square.shift.airplane.strategies.SeatAssignStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {



    private SeatAssignStrategy seatAssignStrategy;

    @Autowired
    public SeatService(  @Qualifier("seatAssignStrategy")SeatAssignStrategy seatAssignStrategy, AirplaneSeatReppositoryService airplaneSeatReppositoryService) {
        this.seatAssignStrategy = seatAssignStrategy;
        this.airplaneSeatReppositoryService = airplaneSeatReppositoryService;
    }

    @Autowired
    private  AirplaneSeatReppositoryService airplaneSeatReppositoryService;


    public void initSeatService(List<SeatGroup> seatGroups)
    {
        airplaneSeatReppositoryService.initSeatRepository(seatGroups);
    }

    public boolean assignSeats(int seatCount)
    {
        return seatAssignStrategy.assignSeat(seatCount);
    }
}
