import java.util.List;
import java.time.LocalDateTime;

public class Festival extends Event {
    private String festivalName;
    private String organizer;
    private List<String> performers;
    private boolean isMultiDay;
    private String festivalType; 

    public Festival(String eventId, String title, String category, LocalDateTime dateTime,
                   Venue venue, double basePrice, double durationHours, int numberOfDays,
                   List<Seat> seats, String festivalName, String organizer, List<String> performers,
                   boolean isMultiDay, String festivalType) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.festivalName = festivalName;
        this.organizer = organizer;
        this.performers = performers;
        this.isMultiDay = isMultiDay;
        this.festivalType = festivalType;
    }

    @Override
    public String getEventDetails() {
    String details = "Festival: " + festivalName + "\n";
    details += "Type: " + festivalType + "\n";
    details += "Organizer: " + organizer + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours\n";
    details += "Multi-day: " + (isMultiDay ? "Yes" : "No") + "\n";
    details += "Performers: " + String.join(", ", performers);
    return details;
}


    @Override
    public double calculatePrice() {
        
        double price = basePrice;
        
        
        if (isMultiDay) {
            price *= 1.4;
        }
        
        
        if (dateTime.getDayOfWeek().getValue() >= 6) { 
            price *= 1.25;
        }
        
        
        if (performers.size() > 5) {
            price *= 1.2;
        }
        
        
        for (Seat seat : seats) {
            if (seat.getRow() <= 3) {
                price *= 1.5;
                break;
            }
        }
        
        return price;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public String getOrganizer() {
        return organizer;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public boolean isMultiDay() {
        return isMultiDay;
    }

    public String getFestivalType() {
        return festivalType;
    }
}
