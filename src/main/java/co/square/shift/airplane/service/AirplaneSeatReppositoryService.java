package co.square.shift.airplane.service;

import co.square.shift.airplane.model.Seat;
import co.square.shift.airplane.model.SeatGroup;
import co.square.shift.airplane.model.SeatType;
import co.square.shift.airplane.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirplaneSeatReppositoryService {



    private SeatsRepository windowSeatAvailable;
    private SeatsRepository aisleSeatAvailable;
    private SeatsRepository middleSeatAvailable;

    @Autowired
    public AirplaneSeatReppositoryService(@Qualifier("windowSeatAvailable") SeatsRepository windowSeatAvailable, @Qualifier("aisleSeatAvailable") SeatsRepository aisleSeatAvailable, @Qualifier("middleSeatAvailable") SeatsRepository middleSeatAvailable) {
        this.windowSeatAvailable = windowSeatAvailable;
        this.aisleSeatAvailable = aisleSeatAvailable;
        this.middleSeatAvailable = middleSeatAvailable;
    }

    public void initSeatRepository(final List<SeatGroup> seatGroups) {

        int row = 0;
        int column = 0;

        for (SeatGroup seatGroup : seatGroups) {
            row = seatGroup.getRowCount();
            column = seatGroup.getColumnCount();

            for (int i = 0; i < row; i++) {
                ArrayList<Seat> rowSeats = seatGroup.getSeats().get(i);

                for (int j = 0; j < column; j++) {
                    Seat seat = rowSeats.get(j);
                    updateSeatRepository(seat);
                }
            }
        }
    }


    private void updateSeatRepository(Seat seat)
    {

        if(seat.getSeatType() == SeatType.ASILE)
            aisleSeatAvailable.addSeat(seat);
        else if(seat.getSeatType() == SeatType.MIDDLE)
            middleSeatAvailable.addSeat(seat);
        else if(seat.getSeatType() == SeatType.WINDOW)
            windowSeatAvailable.addSeat(seat);
    }
}
