import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private List<Ticket> bookedTickets;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bookedTickets = new ArrayList<>();
    }

    public void bookTicket(Ticket ticket) {
        if (ticket != null) {
            bookedTickets.add(ticket);
        }
    }

    public void cancelTicket(String ticketId) {
        bookedTickets.removeIf(ticket -> ticket.getTicketId().equals(ticketId));
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void viewBookedTickets() {
        if (bookedTickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
            return;
        }
        System.out.println("\n=== Your Booked Tickets ===");
        for (Ticket ticket : bookedTickets) {
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Event: " + ticket.getEvent().getTitle());
            System.out.println("Seat: " + ticket.getSeat().getSeatNumber());
            System.out.println("Price: $" + ticket.getPrice());
            System.out.println("------------------------");
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }
}



