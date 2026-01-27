public class Booking {

    int Booking_id;
    Ride ride;
    User user;
    int seats_booked;
    double total_fare;

    public Booking(int booking_id, Ride ride, User user, int seats_booked, double total_fare) {
        Booking_id = booking_id;
        this.ride = ride;
        this.user = user;
        this.seats_booked = seats_booked;
        this.total_fare = total_fare;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Booking_id=" + Booking_id +
                ", ride=" + ride +
                ", user=" + user +
                ", seats_booked=" + seats_booked +
                ", Total_fare=" + total_fare +
                '}';
    }
}
