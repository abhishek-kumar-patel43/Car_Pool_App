public class Ride {
    private int id;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;
    private User driver;

    public Ride(int id, String source, String destination, int totalSeats, double fare, User driver) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
        this.driver = driver;
    }

    public int getId() { return id; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getFare() { return fare; }

    public boolean bookSeats(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ride{id=" + id +
                ", " + source + " -> " + destination +
                ", seats=" + availableSeats +
                ", fare=" + fare +
                ", driver=" + driver.getName() + "}";
    }
}
