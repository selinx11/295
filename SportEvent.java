import java.time.LocalDateTime;
import java.util.List;

public class SportEvent extends Event {
    private String sportType;
    private String homeTeam;
    private String awayTeam;
    private String league;
    private boolean isChampionship;

    public SportEvent(String eventId, String title, String category, LocalDateTime dateTime,
                     Venue venue, double basePrice, double durationHours, int numberOfDays,
                     List<Seat> seats, String sportType, String homeTeam, String awayTeam,
                     String league, boolean isChampionship) {
        super(eventId, title, category, dateTime, venue, basePrice, durationHours, numberOfDays, seats);
        this.sportType = sportType;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.league = league;
        this.isChampionship = isChampionship;
    }

    @Override
    public String getEventDetails() {
    String details = "Sport Event: " + title + "\n";
    details += "Type: " + sportType + "\n";
    details += "Teams: " + homeTeam + " vs " + awayTeam + "\n";
    details += "League: " + league + "\n";
    details += "Venue: " + venue.getName() + "\n";
    details += "Date: " + dateTime.toString() + "\n";
    details += "Duration: " + durationHours + " hours\n";
    details += "Championship Match: " + (isChampionship ? "Yes" : "No");
    return details;
}

    @Override
    public double calculatePrice() {
        
        double price = basePrice;
        
        
        if (isChampionship) {
            price *= 1.5;
        }
        
        
        if (dateTime.getDayOfWeek().getValue() >= 6) { 
            price *= 1.3;
        }
        
        
        for (Seat seat : seats) {
            if (seat.getRow() <= 5) {
                price *= 1.4;
                break;
            }
        }
        
        return price;
    }

    public String getSportType() {
        return sportType;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getLeague() {
        return league;
    }

    public boolean isChampionship() {
        return isChampionship;
    }
}
