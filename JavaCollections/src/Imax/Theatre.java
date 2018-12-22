package Imax;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new LinkedList<>();
//    private LinkedHashSet<Seat> seats = new LinkedHashSet<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int laseRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= laseRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);

            }
        }
    }

    public String getTheatreName() {
        return this.theatreName;
    }

    public boolean reservedSeat(String seatNumber) {

        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
//
//        Seat requestedSeat = null;
//        for (Seat seat : seats) {
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    //    For testing .
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {

            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved .");
                return true;
            } else {
                System.out.println("Seat " + this.seatNumber + " already reserved .");
                return false;
            }
        }

        public boolean cancel() {

            if (this.reserved) {
                this.reserved = false;
                System.out.println("Seat " + this.seatNumber + " reserved .");
                return true;
            } else {
                return false;
            }
        }
    }

}
