import java.util.ArrayList;
import java.util.List;

public class Venue {

    private String name;
    private String address;
    private int capacity;
    private List<Seat> seats;

    public Venue(String venueId, String name, String address, int capacity) {
       
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        if (seats.size() < capacity) {
            seats.add(seat);
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

   
    public String getVenueDetails() {
       return name + " - " + address + " (Capacity: " + capacity + ")";

}
}


