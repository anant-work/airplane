package co.square.shift.airplane.strategies;

import co.square.shift.airplane.exception.NoSeatAvailableException;
import co.square.shift.airplane.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("seatAssignStrategy")
public class AsileWindowMiddleAssignSeatStrategy implements SeatAssignStrategy {


    private SeatsRepository windowSeatAvailable;
    private SeatsRepository aisleSeatAvailable;
    private SeatsRepository middleSeatAvailable;


    @Autowired
    public AsileWindowMiddleAssignSeatStrategy(@Qualifier("windowSeatAvailable") SeatsRepository windowSeatAvailable, @Qualifier("aisleSeatAvailable") SeatsRepository aisleSeatAvailable, @Qualifier("middleSeatAvailable") SeatsRepository middleSeatAvailable) {
        this.windowSeatAvailable = windowSeatAvailable;
        this.aisleSeatAvailable = aisleSeatAvailable;
        this.middleSeatAvailable = middleSeatAvailable;
    }

    @Override
    public boolean assignSeat(int seatCount) throws NoSeatAvailableException {

        //asile seat first
        int assignSeats = assignSeat(aisleSeatAvailable, seatCount, 0);

        if (seatCount - assignSeats > 0)
            assignSeats += assignSeat(windowSeatAvailable, seatCount - assignSeats, assignSeats);

        if (seatCount - assignSeats > 0)
            assignSeats += assignSeat(middleSeatAvailable, seatCount - assignSeats, assignSeats);

        if (seatCount - assignSeats > 0)
            throw new NoSeatAvailableException("Airplane capacity is full no seats available ");

        return true;
    }

    private int assignSeat(SeatsRepository seatsRepository, int seatCount, int startNumber) {

        int assignSeats = 0;
        while ((seatsRepository.getCurrAvailableSeat() > 0
                && (seatCount - ++startNumber) >= 0)) {
            seatsRepository.assignSeat(String.valueOf(startNumber));
            assignSeats++;
        }

        return assignSeats > 0 ? assignSeats : 0;
    }
}
