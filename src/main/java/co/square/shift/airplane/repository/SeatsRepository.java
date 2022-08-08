package co.square.shift.airplane.repository;

import co.square.shift.airplane.model.Seat;

public interface SeatsRepository {

    public boolean isSeatAvaible();
    public void addSeat(Seat seat);
    public Seat assignSeat(String passengerNumber);
    public int getCurrAvailableSeat();

}
