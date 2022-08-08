package co.square.shift.airplane.strategies;

import co.square.shift.airplane.exception.NoSeatAvailableException;

public interface SeatAssignStrategy {

    public boolean assignSeat(int seatCount) throws NoSeatAvailableException;
}
