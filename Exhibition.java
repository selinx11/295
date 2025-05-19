import java.time.LocalDateTime;
import java.util.List;

public class Exhibition extends Event {
    private String exhibitionName;
    private String artist;
    private String artStyle;

    public Exhibition(String eventId, String title, String category, LocalDateTime dateTime,
                     Venue venue, double basePrice, double durationHours, int numberOfDays,
                     List<Seat> seats, String exhibitionName, String artist, String artStyle) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.exhibitionName = exhibitionName;
        this.artist = artist;
        this.artStyle = artStyle;
        
    }

    @Override
    public String getEventDetails() {
    String details = "Exhibition: " + exhibitionName + "\n";
    details += "Artist: " + artist + "\n";
    details += "Style: " + artStyle + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours\n";
    
    return details;
}


    @Override
    public double calculatePrice() {
        
        double price = basePrice;
     
        
        
        if (dateTime.getDayOfWeek().getValue() >= 6) { 
            price *= 1.15;
        }
        return price;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public String getArtist() {
        return artist;
    }

    public String getArtStyle() {
        return artStyle;
    }

    
    
}
    