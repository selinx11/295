import java.time.LocalDateTime;
import java.util.List;

public abstract class Event {
    protected String eventId;
    protected String title;
    protected String category;
    protected LocalDateTime dateTime;
    protected Venue venue;
    protected double basePrice;
    protected double durationHours;
    protected int numberOfDays;
    protected List<Seat> seats;

    public Event(String eventId, String title, String category, LocalDateTime dateTime,
                 Venue venue, double basePrice, double durationHours, int numberOfDays,
                 List<Seat> seats) {
        this.eventId = eventId;
        this.title = title;
        this.category = category;
        this.dateTime = dateTime;
        this.venue = venue;
        this.basePrice = basePrice;
        this.durationHours = durationHours;
        this.numberOfDays = numberOfDays;
        this.seats = seats;
    }

    
    public abstract String getEventDetails();
    public abstract double calculatePrice();

    
    public List<Seat> getAvailableSeats() {
        return seats;
    }

    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    
    public final void processEvent() {
        validateEvent();
        calculatePrice();
        updateSeats();
    }

    protected void validateEvent() {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Event date cannot be in the past");
        }
        if (seats.isEmpty()) {
            throw new IllegalStateException("Event must have at least one seat");
        }
    }

    protected void updateSeats() {
        
        for (Seat seat : seats) {
            if (seat.isBooked()) {
                seat.bookSeat();
            }
        }
    }
}


