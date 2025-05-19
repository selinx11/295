import java.time.LocalDateTime;
import java.util.List;

public class Theater extends Event {
    private String playName;
    private String playwright;
    private String style;

    public Theater(String eventId, String title, String category, LocalDateTime dateTime,
                  Venue venue, double basePrice, double durationHours, int numberOfDays,
                  List<Seat> seats, String playName, String playwright, String style) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.playName = playName;
        this.playwright = playwright;
        this.style = style;
    }

    @Override
    public String getEventDetails() {
    String details = "Theater: " + title + "\n";
    details += "Play: " + playName + "\n";
    details += "Playwright: " + playwright + "\n";
    details += "Style: " + style + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours";
    return details;
}


    @Override
    public double calculatePrice() {
        
        double price = basePrice;
    
        if (dateTime.getHour() >= 18) { 
            price *= 1.3;
        }
        return price;
    }

    public String getPlayName() {
        return playName;
    }

    public String getPlaywright() {
        return playwright;
    }

    public String getStyle() {
        return style;
    }
}

