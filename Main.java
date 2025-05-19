import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;
    private static Admin currentAdmin = null;

    public static void main(String[] args) {
        try {
            initializeData();
            showMainMenu();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void initializeData() {
        admins.add(new Admin("A1", "idil", "idil123"));
        admins.add(new Admin("A2", "selin", "selin123"));
        users.add(new User("U1", "Mehmet", "mehmet@gmail.com", "mehmet123"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== Ticket Booking System ===");
            System.out.println("1. User Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Register");
            System.out.println("4. View Events");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    viewEvents();
                    break;
                case 5:
                    System.out.println("Thank you for using the Ticket Booking System!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void userLogin() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.validatePassword(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + user.getName());
                showUserMenu();
                return;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
    }

    private static void adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.validatePassword(password)) {
                currentAdmin = admin;
                System.out.println("Admin login successful! Welcome, " + admin.getUsername());
                showAdminMenu();
                return;
            }
        }
        System.out.println("Invalid admin credentials. Please try again.");
    }

    private static void register() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Invalid email format. Please try again.");
                return;
            }
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    System.out.println("Email already registered. Please use a different email.");
                    return;
                }
            }
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            User newUser = new User("U" + (users.size() + 1), name, email, password);
            users.add(newUser);
            System.out.println("Registration successful! Please login.");
        } catch (Exception e) {
            System.out.println("An error occurred during registration. Please try again.");
            scanner.nextLine();
        }
    }

    private static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        System.out.println("\n=== Available Events ===");
        for (Event event : events) {
            System.out.println(event.getEventDetails());
        }
    }

    private static void showUserMenu() {
        while (currentUser != null) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. View Events");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewEvents();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    currentUser.viewBookedTickets();
                    break;
                case 4:
                    cancelTicket();
                    break;
                case 5:
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showAdminMenu() {
        while (currentAdmin != null) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    currentAdmin = null;
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEvent() {
        System.out.println("\n=== Add New Event ===");
        System.out.println("1. Cinema");
        System.out.println("2. Concert");
        System.out.println("3. Theater");
        System.out.println("4. Exhibition");
        System.out.println("5. Festival");
        System.out.println("6. Sport Event");
        System.out.print("Choose event type: ");

        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Enter event title: ");
        String title = scanner.nextLine();
        System.out.print("Enter event ID: ");
        String eventId = scanner.nextLine();

        double basePrice;
        System.out.print("Enter base price: ");
        try {
            basePrice = scanner.nextDouble();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid price format. Please enter a number.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Enter venue name: ");
        String venueName = scanner.nextLine();
        System.out.print("Enter venue address: ");
        String venueAddress = scanner.nextLine();
        System.out.println("Enter the Duration Hours (e.g. 0.5)");
        double duration = Double.parseDouble(scanner.nextLine());

        int capacity;
        System.out.print("Enter venue capacity: ");
        try {
            capacity = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid capacity. Please enter an integer.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Venue venue = new Venue("V" + (events.size() + 1), venueName, venueAddress, capacity);

        System.out.print("Enter event date/time (yyyy-MM-dd HH:mm): ");
        String dateInput = scanner.nextLine();
        LocalDateTime eventDate;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            eventDate = LocalDateTime.parse(dateInput, fmt);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format: expected yyyy-MM-dd HH:mm");
            eventDate = LocalDateTime.now();
        }

        List<Seat> seats = new ArrayList<>();
        int rows = (int) Math.ceil(Math.sqrt(capacity));
        int seatsPerRowDynamic = (int) Math.ceil((double) capacity / rows);
        int seatCount = 0;
        for (int r = 1; r <= rows && seatCount < capacity; r++) {
            for (int c = 1; c <= seatsPerRowDynamic && seatCount < capacity; c++) {
                seats.add(new Seat("S" + r + "-" + c, r, c, false, 1.0));
                seatCount++;
            }
        }

        Event event;
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    event = new Cinema("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            movieTitle, genre);
                    break;
                case 2:
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter music genre: ");
                    String musicGenre = scanner.nextLine();
                    event = new Concert("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            artist, musicGenre);
                    break;
                case 3:
                    System.out.print("Enter play name: ");
                    String playName = scanner.nextLine();
                    System.out.print("Enter playwright: ");
                    String playwright = scanner.nextLine();
                    event = new Theater("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            playName, playwright, "Classical");
                    break;
                case 4:
                    System.out.print("Enter exhibition name: ");
                    String exhibitionName = scanner.nextLine();
                    System.out.print("Enter exhibition artist: ");
                    String exhibitionArtist = scanner.nextLine();
                    System.out.print("Enter style/theme: ");
                    String artStyle = scanner.nextLine();
                    event = new Exhibition("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            exhibitionName, exhibitionArtist, artStyle);
                    break;
                case 5:
                    System.out.print("Enter festival name: ");
                    String festName = scanner.nextLine();
                    System.out.print("Enter organizer: ");
                    String organizer = scanner.nextLine();
                    System.out.print("Enter comma-separated performers: ");
                    List<String> performers = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
                    System.out.print("Is it multi-day? (true/false): ");
                    boolean multiDay = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Enter festival type: ");
                    String festType = scanner.nextLine();
                    event = new Festival("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            festName, organizer, performers, multiDay, festType);
                    break;
                case 6:
                    System.out.print("Enter sport type: ");
                    String sportType = scanner.nextLine();
                    System.out.print("Enter home team: ");
                    String homeTeam = scanner.nextLine();
                    System.out.print("Enter away team: ");
                    String awayTeam = scanner.nextLine();
                    System.out.print("Enter league: ");
                    String leagueInput = scanner.nextLine();
                    System.out.print("Is this a championship? (true/false): ");
                    boolean championship = scanner.nextBoolean();
                    scanner.nextLine();
                    event = new SportEvent("E" + (events.size() + 1), title, eventId,
                            eventDate, venue, basePrice, duration, 1, seats,
                            sportType, homeTeam, awayTeam, leagueInput, championship);
                    break;
                default:
                    System.out.println("Invalid event type.");
                    return;
            }
        } catch (Exception e) {
            System.out.println("Error creating event: " + e.getMessage());
            return;
        }

        events.add(event);
        System.out.println("Event added successfully! Total seats: " + seats.size());
    }

    private static void bookTicket() {
        try {
            viewEvents();
            if (events.isEmpty()) return;

            System.out.print("Enter event title to book: ");
            String eventTitle = scanner.nextLine();
            Event selectedEvent = null;
            for (Event ev : events) if (ev.getTitle().equals(eventTitle)) { selectedEvent = ev; break; }

            if (selectedEvent != null) {
                System.out.println("Available seats:");
                for (Seat s : selectedEvent.getSeats()) if (!s.isBooked()) System.out.println(s.getSeatNumber());

                System.out.print("Enter seat number to book: ");
                String seatNum = scanner.nextLine();
                Seat chosen = null;
                for (Seat s : selectedEvent.getSeats()) {
                    if (s.getSeatNumber().equals(seatNum) && !s.isBooked()) { chosen = s; break; }
                }
                if (chosen != null) {
                    chosen.setBooked(true);
                    Ticket t = new Ticket("T" + (currentUser.getBookedTickets().size() + 1),
                            selectedEvent, chosen, selectedEvent.calculatePrice());
                    currentUser.getBookedTickets().add(t);
                    System.out.println("Booked! TicketID=" + t.getTicketId() + ", Price=$" + t.getPrice());
                } else System.out.println("Invalid or already booked seat.");
            } else System.out.println("Event not found.");
        } catch (Exception e) {
            System.out.println("An error occurred while booking ticket: " + e.getMessage());
        }
    }

    private static void cancelTicket() {
        if (currentUser.getBookedTickets().isEmpty()) {
            System.out.println("You have no tickets to cancel.");
            return;
        }
        System.out.println("\n=== Your Tickets ===");
        currentUser.viewBookedTickets();
        System.out.print("Enter Ticket ID to cancel (e.g., T1): ");
        String ticketId = scanner.nextLine();

        boolean found = false;
        Iterator<Ticket> it = currentUser.getBookedTickets().iterator();
        while (it.hasNext()) {
            Ticket t = it.next();
            if (t.getTicketId().equals(ticketId)) {
                t.getSeat().setBooked(false);
                it.remove(); found = true; break;
            }
        }
        System.out.println(found ? "Ticket cancelled successfully!" : "Invalid Ticket ID or ticket not found.");
    }
}

