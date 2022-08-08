package co.square.shift.airplane.model;

public class MiddleSeat extends  Seat{
    public MiddleSeat(int row, int column, int seatGroupNumber) {
        super(row, column, seatGroupNumber, SeatType.MIDDLE);
    }
}
