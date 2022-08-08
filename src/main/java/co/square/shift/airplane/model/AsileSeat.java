package co.square.shift.airplane.model;

public class AsileSeat extends  Seat{
    public AsileSeat(int row, int column, int seatGroupNumber) {
        super(row, column, seatGroupNumber, SeatType.ASILE);
    }
}
