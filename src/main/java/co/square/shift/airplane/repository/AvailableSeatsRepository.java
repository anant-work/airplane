package co.square.shift.airplane.repository;

import co.square.shift.airplane.model.Seat;
import co.square.shift.airplane.model.SeatStatus;

import java.util.PriorityQueue;


public class AvailableSeatsRepository implements  SeatsRepository{

    private PriorityQueue<Seat> seats;
    private int currAvailableSeat;

    public AvailableSeatsRepository()
    {
        seats = new PriorityQueue<>();
    }

    public boolean isSeatAvaible()
    {
        return seats.size() > 0? true : false;
    }

    public void addSeat(Seat seat)
    {
        seats.add(seat);
        currAvailableSeat++;
    }

    public Seat assignSeat(String passengerNumber)
    {
        currAvailableSeat--;
        Seat seat = seats.poll();
        seat.setPassengerNumber(passengerNumber);
        seat.setSeatStatus(SeatStatus.OCCUPIED);
        return seat;
    }

    public int getCurrAvailableSeat() {
        return currAvailableSeat;
    }


}
