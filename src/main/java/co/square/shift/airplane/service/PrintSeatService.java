package co.square.shift.airplane.service;

import co.square.shift.airplane.constants.TextColourConstants;
import co.square.shift.airplane.model.Airplane;
import co.square.shift.airplane.model.Seat;
import co.square.shift.airplane.model.SeatGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintSeatService {

    public void printAirplaneSeat(final Airplane airplane)
    {
        List<SeatGroup> seatGroups = airplane.getSeatGroups();

        for(int row = 0 ; row < airplane.getMaxRowInSeatGroup() ; row++)
        {

                for(int i = 1 ; i <= seatGroups.size() ; i++) {
                    SeatGroup seatGroup = seatGroups.get(i - 1);

                    if (row < seatGroup.getRowCount())
                        printSeat(seatGroup, row);
                    else
                        printBlank(seatGroup.getColumnCount());
                }

            System.out.println("\n\n");
        }

    }


    private void printSeat(SeatGroup seatGroup, int row)
    {
        List<Seat> seatRow = seatGroup.getSeats().get(row);

        for(int i = 0 ; i < seatGroup.getColumnCount() ; i++)
        {
            Seat seat = seatRow.get(i);

            switch(seat.getSeatStatus())
            {
                case AVAILABLE:
                    printSeatDetails(TextColourConstants.ANSI_GREEN, seat);
                    break;
                case OCCUPIED:
                    printSeatDetails(TextColourConstants.ANSI_RED,seat);
                    break;
            }
        }
    }

    private void printSeatDetails(String textColour, Seat seat)
    {
        System.out.print("\t"+ textColour
                + seat.getSeatNumber()
                + TextColourConstants.ANSI_RESET);
    }

    private void printBlank(int column)
    {
        for(int i = 0 ; i < column ; i++)
            System.out.print("\t");
    }
}
