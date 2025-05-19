import java.time.LocalDateTime;
import java.util.List;

public class Concert extends Event {
    private String artist;
    private String musicGenre;

    public Concert(String eventId, String title, String category, LocalDateTime dateTime,
                  Venue venue, double basePrice, double durationHours, int numberOfDays,
                  List<Seat> seats, String artist, String musicGenre) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.artist = artist;
        this.musicGenre = musicGenre;
    }

    @Override
    public String getEventDetails() {
    String details = "Concert: " + title + "\n";
    details += "Artist: " + artist + "\n";
    details += "Genre: " + musicGenre + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours";
    return details;
}


    @Override
    public double calculatePrice() {
    
        double price = basePrice;
    
        for (Seat seat : seats) {
            if (seat.getRow() <= 3) {
                price *= 1.5;
                break;
            }
        }
        return price;
    }

    public String getArtist() {
        return artist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }
}