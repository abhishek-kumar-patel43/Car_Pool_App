import java.util.*;

public class RideBookingSystem {

    private List<User> users = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    private int bookingCounter = 1;

    public void addUser(User user) {
        users.add(user);
    }

    public void createRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> searchRides(String source, String destination) {
        List<Ride> result = new ArrayList<>();
        for (Ride r : rides) {
            if (r.getSource().equalsIgnoreCase(source) &&
                    r.getDestination().equalsIgnoreCase(destination) &&
                    r.getAvailableSeats() > 0) {
                result.add(r);
            }
        }
        return result;
    }

    public Booking bookRide(int rideId, int userId, int seats) {
        Ride selectedRide = null;
        User rider = null;

        for (Ride r : rides) {
            if (r.getId() == rideId) {
                selectedRide = r;
                break;
            }
        }

        for (User u : users) {
            if (u.getId() == userId) {
                rider = u;
                break;
            }
        }

        if (selectedRide == null || rider == null) {
            System.out.println("Invalid ride or user ID.");
            return null;
        }

        if (selectedRide.bookSeats(seats)) {
            Booking booking = new Booking(bookingCounter++, selectedRide, rider, seats);
            bookings.add(booking);
            return booking;
        } else {
            System.out.println("Not enough seats available.");
            return null;
        }
    }

    public void showAllRides() {
        for (Ride r : rides) {
            System.out.println(r);
        }
    }
}
public User login(int userId, String password) {
    for (User u : users) {
        if (u.getId() == userId && u.checkPassword(password)) {
            return u;
        }
    }
    return null;
}
