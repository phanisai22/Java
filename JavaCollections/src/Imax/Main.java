package Imax;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("AMB Multiplex", 8, 12);
//        theatre.getSeats();

        System.out.println(theatre.getTheatreName());
        theatre.reservedSeat("A02");
        theatre.reservedSeat("A02");
        theatre.reservedSeat("M01");

//        theatre.getSeats();
    }

}
