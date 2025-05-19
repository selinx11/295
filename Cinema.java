import java.time.LocalDateTime;
import java.util.List;

public class Cinema extends Event {
    private String movieTitle;
    private String genre;
    

    public Cinema(String eventId, String title, String category, LocalDateTime dateTime,
                Venue venue, double basePrice, double durationHours, int numberOfDays, 
                 List<Seat> seats, String movieTitle, String genre) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.movieTitle = movieTitle;
        this.genre = genre;
        
    }

    

    @Override
    public String getEventDetails() {
    String details = "Cinema: " + movieTitle + "\n";
    details += "Genre: " + genre + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours";
    return details;
}

    @Override
    public double calculatePrice() {
        
        double price = basePrice;
        
        if (dateTime.getDayOfWeek().getValue() >= 6) { 
            price *= 1.2;
        }
        return price;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getGenre() {
        return genre;
    }

   }


