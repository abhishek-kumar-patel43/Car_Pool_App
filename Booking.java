public class Booking {
    private int id;
    private Ride ride;
    private User rider;
    private int seatsBooked;
    private double totalAmount;

    public Booking(int id, Ride ride, User rider, int seatsBooked) {
        this.id = id;
        this.ride = ride;
        this.rider = rider;
        this.seatsBooked = seatsBooked;
        this.totalAmount = seatsBooked * ride.getFare();
    }

    @Override
    public String toString() {
        return "Booking{id=" + id +
                ", rider=" + rider.getName() +
                ", ride=" + ride.getId() +
                ", seats=" + seatsBooked +
                ", total=" + totalAmount + "}";
    }
}
