import java.util.*;

public class Main {
    public static void main(String[] args) {

        RideBookingSystem system = new RideBookingSystem();
        Scanner sc = new Scanner(System.in);

        // Pre-registered users
        system.addUser(new User(1, "Amit", "DRIVER", "1234"));
        system.addUser(new User(2, "Rahul", "RIDER", "abcd"));

        system.createRide(new Ride(1, "Delhi", "Noida", 3, 150,
                new User(1, "Amit", "DRIVER", "1234")));

        System.out.println("=== LOGIN ===");
        System.out.print("User ID: ");
        int id = sc.nextInt();
        System.out.print("Password: ");
        String pass = sc.next();

        User loggedInUser = system.login(id, pass);

        if (loggedInUser == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome " + loggedInUser.getName());

        while (true) {
            if (loggedInUser.getRole().equals("DRIVER")) {
                System.out.println("\n1. Create Ride");
                System.out.println("2. Show All Rides");
                System.out.println("0. Logout");

                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Ride ID: ");
                    int rideId = sc.nextInt();
                    System.out.print("Source: ");
                    String src = sc.next();
                    System.out.print("Destination: ");
                    String dest = sc.next();
                    System.out.print("Seats: ");
                    int seats = sc.nextInt();
                    System.out.print("Fare: ");
                    double fare = sc.nextDouble();

                    system.createRide(new Ride(rideId, src, dest, seats, fare, loggedInUser));
                }

                else if (choice == 2) {
                    system.showAllRides();
                }

                else if (choice == 0) break;
            }

            else if (loggedInUser.getRole().equals("RIDER")) {
                System.out.println("\n1. Search Ride");
                System.out.println("2. Book Ride");
                System.out.println("0. Logout");

                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Source: ");
                    String src = sc.next();
                    System.out.print("Destination: ");
                    String dest = sc.next();

                    List<Ride> rides = system.searchRides(src, dest);
                    for (Ride r : rides) System.out.println(r);
                }

                else if (choice == 2) {
                    System.out.print("Ride ID: ");
                    int rideId = sc.nextInt();
                    System.out.print("Seats: ");
                    int seats = sc.nextInt();

                    Booking b = system.bookRide(rideId, loggedInUser.getId(), seats);
                    if (b != null) System.out.println("Booked: " + b);
                }

                else if (choice == 0) break;
            }
        }
    }
}
