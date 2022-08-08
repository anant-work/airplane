package co.square.shift.airplane.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class SeatGroup {

    private int rowCount;
    private  int columnCount;

    private ArrayList<ArrayList<Seat>> seats;

    public SeatGroup(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }




}
