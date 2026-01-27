import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    List<User> users = new ArrayList<>();
    List<Ride> rideList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();

    public User signup(int user_id, String name, String email, String password) {
        User user = new User(user_id, name, email, password);
        users.add(user);
        return user;
    }

    public User login(String email, String password) {
        for (User u : users) {
            if (u.email.equals(email) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void updateUserDetails(User user, String name, String email) {
        user.name = name;
        user.email = email;
    }

    public void deleteUserDetails(User user) {
        users.remove(user);
    }

    public void createRide(int id, String source, String destination, int seats, double fare, User user) {
        Ride ride = new Ride(id, source, destination, seats, fare, user);
        rideList.add(ride);
    }

    public List<Ride> showAllRide() {
        return rideList;
    }

    public List<Ride> searchRide(String source, String destination, int seats) {
        List<Ride> availableRide = new ArrayList<>();
        for (Ride ride : rideList) {
            if (ride.source.equals(source) &&
                    ride.destination.equals(destination) &&
                    ride.seats >= seats) {
                availableRide.add(ride);
            }
        }
        return availableRide;
    }

    public void updateRide(Ride ride, int seats, double fare) {
        ride.seats = seats;
        ride.fare = fare;
    }

    public void deleteRide(Ride ride) {
        rideList.remove(ride);
    }

    public Booking bookRide(Ride ride, User user, int seatsBooked) {
        if (ride.seats < seatsBooked) return null;

        ride.seats -= seatsBooked;
        Booking booking = new Booking(
                bookingList.size() + 1,
                user,
                ride,
                seatsBooked,
                seatsBooked * ride.fare
        );
        bookingList.add(booking);
        return booking;
    }

    public List<Ride> viewRideCreated(User user) {
        List<Ride> viewCreated = new ArrayList<>();
        for (Ride ride : rideList) {
            if (ride.user.equals(user)) {
                viewCreated.add(ride);
            }
        }
        return viewCreated;
    }

    public List<Booking> viewRideBooked(User user) {
        List<Booking> viewBooked = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.user.equals(user)) {
                viewBooked.add(booking);
            }
        }
        return viewBooked;
    }

    public void updateBooking(Booking booking, int newSeats) {
        int diff = newSeats - booking.seats_booked;
        if (booking.ride.seats >= diff) {
            booking.ride.seats -= diff;
            booking.seats_booked = newSeats;
            booking.total_fare = newSeats * booking.ride.fare;
        }
    }

    public void deleteBooking(Booking booking) {
        booking.ride.seats += booking.seats_booked;
        bookingList.remove(booking);
    }
}
