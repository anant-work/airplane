package co.square.shift.airplane.factories;

import co.square.shift.airplane.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public class SeatGroupFactory {


    public static SeatGroup createSeatGroup(int row, int column, int seatGroupSequence, SeatGroupType seatGroupType )
    {
        SeatGroup seatGroup = new SeatGroup(row,column);
        ArrayList<ArrayList<Seat>> seats = null;

        if(seatGroupType == SeatGroupType.FIRST_LAST)
            seats = createFirstLastSeatGroup(row,column,seatGroupSequence);
        if(seatGroupType == SeatGroupType.FIRST)
              seats =   createFirstSeatGroup(row,column,seatGroupSequence);
        else if(seatGroupType == SeatGroupType.IN_BETWEEN)
              seats = createMiddleSeatGroup(row,column,seatGroupSequence);
        else if(seatGroupType == seatGroupType.LAST)
             seats = createLastSeatGroup(row,column,seatGroupSequence);

        seatGroup.setSeats(seats);
        return seatGroup;
     }

    static private ArrayList<ArrayList<Seat>>  createFirstSeatGroup(int row, int column, int seatGroupSequence)
    {
        ArrayList<ArrayList<Seat>> seats = new ArrayList<>();
        ArrayList<Seat> rowSeats = null;
        for(int i = 1 ; i <= row ; i++)
        {
            rowSeats = new ArrayList<>();
            for(int j = 1 ; j <= column ; j++)
            {
                if(j == 1)
                 rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.WINDOW));
                else if(j == column)
                 rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.ASILE));
                else if(j > 1 && j < column)
                  rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.MIDDLE));
            }
            seats.add(rowSeats);
        }

        return seats;
    }

    static private ArrayList<ArrayList<Seat>>  createFirstLastSeatGroup(int row, int column, int seatGroupSequence)
    {
        ArrayList<ArrayList<Seat>> seats = new ArrayList<>();
        ArrayList<Seat> rowSeats = null;
        for(int i = 1 ; i <= row ; i++)
        {
            rowSeats = new ArrayList<>();
            for(int j = 1 ; j <= column ; j++)
            {
                if(j == 1 || j == column)
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.WINDOW));
                else if(j > 1 && j < column)
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.MIDDLE));
            }
            seats.add(rowSeats);
        }

        return seats;
    }
    static private ArrayList<ArrayList<Seat>>  createMiddleSeatGroup(int row, int column, int seatGroupSequence)
    {
        ArrayList<ArrayList<Seat>> seats = new ArrayList<>();
        ArrayList<Seat> rowSeats = null;
        for(int i = 1 ; i <= row ; i++)
        {
            rowSeats = new ArrayList<>();
            for(int j = 1 ; j <= column ; j++)
            {
                if(j == 1 || j == column)
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.ASILE));
                else if(j > 1 && j < column)
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.MIDDLE));
            }
            seats.add(rowSeats);
        }

        return seats;
    }

    static private ArrayList<ArrayList<Seat>>  createLastSeatGroup(int row, int column, int seatGroupSequence)
    {
        ArrayList<ArrayList<Seat>> seats = new ArrayList<>();
        ArrayList<Seat> rowSeats = null;
        for(int i = 1 ; i <= row ; i++)
        {
            rowSeats = new ArrayList<>();
            for(int j = 1 ; j <= column ; j++)
            {
                if(j == 1 )
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.ASILE));
                else if(j == column )
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.WINDOW));
                else if(j > 1 && j < column)
                    rowSeats.add(new Seat(i,j,seatGroupSequence, SeatType.MIDDLE));
            }
            seats.add(rowSeats);
        }

        return seats;
    }
}
