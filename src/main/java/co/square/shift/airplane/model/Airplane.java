package co.square.shift.airplane.model;

import co.square.shift.airplane.factories.SeatGroupFactory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

@Getter
public class Airplane {

    private List<SeatGroup> seatGroups;
    private int maxRowInSeatGroup = 0;



    private Airplane()
    {
       seatGroups = new ArrayList<>();
    }


    public static Airplane.Builder getBuuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private ArrayList<ArrayList<Integer>> seatGroupList;

        public Builder()
        {
            seatGroupList = new ArrayList<>();
        }

        public Builder addSeatGroup(Scanner scanner)
        {
            System.out.println("Enter Number of rows for a seat group : ");
            int row = scanner.nextInt();
            System.out.println("Enter Number of Columns for a seat group : ");
            int column = scanner.nextInt();

            ArrayList<Integer> tmpSeatGroup = new ArrayList<>();
            tmpSeatGroup.add(row);
            tmpSeatGroup.add(column);
            seatGroupList.add(tmpSeatGroup);

            return this;
        }

       public Airplane build(Scanner scanner)
       {
           int groupCount = 1;
           Airplane airplane = new Airplane();

           for(ArrayList<Integer> seatGroupDetails : seatGroupList)
           {
               int row = seatGroupDetails.get(0);
               int column = seatGroupDetails.get(1);
               SeatGroup seatGroup =  getSeatGroup(row,column,groupCount,seatGroupList.size());

               airplane.maxRowInSeatGroup  = Math.max(airplane.maxRowInSeatGroup, row);
               airplane.getSeatGroups().add(seatGroup);
               groupCount++;
           }

           return airplane;
       }

        private SeatGroup getSeatGroup(int row, int column, int groupCount, int size)
        {
            SeatGroup seatGroup = null ;

            if(groupCount == 1 && groupCount == size)
                seatGroup = SeatGroupFactory.createSeatGroup(row,column,groupCount,SeatGroupType.FIRST_LAST);
            else if(groupCount == 1)
                seatGroup = SeatGroupFactory.createSeatGroup(row,column,groupCount,SeatGroupType.FIRST);
            else if(groupCount == size)
                seatGroup = SeatGroupFactory.createSeatGroup(row,column, groupCount,SeatGroupType.LAST);
            else
                seatGroup = SeatGroupFactory.createSeatGroup(row,column,groupCount,SeatGroupType.IN_BETWEEN);

            return seatGroup;
        }

    }






}
