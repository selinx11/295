
public class Ticket {
    private String ticketId;
    private Event event;
    private Seat seat;
    private double price;

    public Ticket(String ticketId, Event event, Seat seat, double price) {
        this.ticketId = ticketId;
        this.event = event;
        this.seat = seat;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }
}

