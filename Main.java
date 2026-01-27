import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RideBookingSystem rideBookingSystem = new RideBookingSystem();
        rideBookingSystem.createRide(1, "jaipur", "delhi", 3, 450.00);
        rideBookingSystem.createRide(2, "Patna", "New delhi", 2, 850.00);
        rideBookingSystem.createRide(3, "Kanpur", "Lucknow", 1, 250.00);


        System.out.println(rideBookingSystem.showAllRide());

    }
}


