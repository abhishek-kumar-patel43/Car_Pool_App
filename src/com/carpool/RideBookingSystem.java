package com.carpool;

import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    private List<User> users = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    private int bookingCounter = 1;


    public void addUser(User user) {
        users.add(user);
    }

    public User login(int userId, String password) {
        for (User u : users) {
            if (u.getId() == userId && u.checkPassword(password)) {
                return u;
            }
        }
        return null;
    }

    public User getUserById(int userId) {
        for (User u : users) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }


    public void createRide(Ride ride) {
        rides.add(ride);
    }

    public Ride getRideById(int rideId) {
        for (Ride r : rides) {
            if (r.getId() == rideId) {
                return r;
            }
        }
        return null;
    }

    public List<Ride> searchRides(String source, String destination) {
        List<Ride> result = new ArrayList<>();

        for (Ride r : rides) {
            if (r.getSource().equalsIgnoreCase(source)
                    && r.getDestination().equalsIgnoreCase(destination)
                    && r.getAvailableSeats() > 0) {
                result.add(r);
            }
        }
        return result;
    }

    public void showAllRides() {
        for (Ride r : rides) {
            System.out.println(r);
        }
    }


    public Booking bookRide(int rideId, int userId, int seats) {

        Ride ride = getRideById(rideId);
        User rider = getUserById(userId);

        if (ride == null) {
            System.out.println("Ride not found.");
            return null;
        }

        if (rider == null) {
            System.out.println("User not found.");
            return null;
        }

        if (seats <= 0) {
            System.out.println("Invalid seat count.");
            return null;
        }

        if (!ride.bookSeats(seats)) {
            System.out.println("Not enough seats available.");
            return null;
        }

        Booking booking = new Booking(bookingCounter++, ride, rider, seats);
        bookings.add(booking);
        return booking;
    }

    public void showAllBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}


