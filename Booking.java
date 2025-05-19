import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Event> events;
    private List<Ticket> tickets;

    public Booking() {
        this.events = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public Event findEventByTitle(String title) {
        for (Event event : events) {
            if (event.getTitle().equals(title)) {
                return event;
            }
        }
        return null;
    }

    public void displayAvailableSeats(Event event) {
        System.out.println("Available seats for " + event.getTitle() + ":");
        for (Seat seat : event.getSeats()) {
            if (!seat.isBooked()) {
                System.out.println("Seat " + seat.getSeatNumber());
            }
        }
    }

    public Seat findAvailableSeat(Event event, String seatNumber) {
        for (Seat seat : event.getSeats()) {
            if (seat.getSeatNumber().equals(seatNumber) && !seat.isBooked()) {
                return seat;
            }
        }
        return null;
    }

    public Ticket bookSeat(User user, Event event, Seat seat) {
        if (seat != null && !seat.isBooked()) {
            seat.setBooked(true);
            Ticket ticket = new Ticket("T" + (tickets.size() + 1), event, seat, event.calculatePrice());
            tickets.add(ticket);
            return ticket;
        }
        return null;
    }

    public boolean cancelTicket(String ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(ticketId)) {
                ticket.getSeat().setBooked(false);
                tickets.remove(ticket);
                return true;
            }
        }
        return false;
    }
}

