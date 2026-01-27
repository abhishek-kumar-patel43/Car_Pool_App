public class Ride {

    int id;
    String source;
    String destination;
    int total_seats;
    int avliable_seats;
    double fare;
    User user;

    public Ride(int id, String source, String destination, int total_seats, int avliable_seats, double fare, User user) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.avliable_seats = avliable_seats;
        this.fare = fare;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", avliable_seats=" + avliable_seats +
                ", fare=" + fare +
                ", user=" + user +
                '}';
    }
}
