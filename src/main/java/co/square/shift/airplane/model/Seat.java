package co.square.shift.airplane.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Seat implements Comparable<Seat> {

    private int row;
    private int column;
    private String seatNumber;
    private SeatStatus seatStatus;
    private String passengerNumber;
    private SeatType seatType;



    public Seat(int row, int column, int seatGroupNumber, SeatType seatType) {
        this.row = row;
        this.column = column;
        this.seatNumber = new StringBuffer(String.valueOf(seatGroupNumber)).append("_").append(row).append("_").append(column).toString();
        this.seatStatus = SeatStatus.AVAILABLE;
        this.seatType = seatType;
        this.passengerNumber = null;
    }

    @Override
    public int compareTo(Seat seat) {
        return seatNumber.compareTo(seat.getSeatNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && column == seat.column && Objects.equals(seatNumber, seat.seatNumber) && seatStatus == seat.seatStatus && Objects.equals(passengerNumber, seat.passengerNumber) && seatType == seat.seatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, seatNumber, seatStatus, passengerNumber, seatType);
    }
}
