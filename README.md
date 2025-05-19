# TicketBookingSystem

TicketBookingSystem is a Java console application that simulates a real-world ticketing platform for events—cinema, concerts, theater, exhibitions, festivals, and sports. Its mission is “Bringing You Closer to Live Experiences” by handling user registration, event management, ticket booking, and cancellation with clean OOP design.

## Features

### User Management
- Multiple roles: *User, **Admin*  
- Simple registration/login (email checked for @ and .)  
- Profile-freezing on wrong credentials (no hacking allowed)

### Event Management
- *Admin* can add new events via addEvent()  
- Supports 6 event types (Cinema, Concert, Theater, Exhibition, Festival, SportEvent)  
- Dynamic seating layout generated from capacity (no more manual seat charts!)  

### Booking System
- Users browse events with viewEvents()  
- *Book Ticket* (bookTicket()): checks seat availability, prevents double-booking  
- *Cancel Ticket* (cancelTicket()): frees up seats instantly  
- *View My Tickets* (currentUser.viewBookedTickets())

### Date/Time Handling
- Enforces strict **yyyy-MM-dd HH:mm** format with DateTimeFormatter  
- Falls back to current time on parse errors  

### Input Validation
- All numeric inputs (nextInt(), nextDouble()) wrapped in try/catch(InputMismatchException)  
- Graceful prompts on invalid entries—no full-stop crashes  

## User Roles

### Admin
- Accessed via adminLogin()  
- *Add Event* (addEvent())  
- *View All Events* (viewEvents())  
- *Logout*

### User
- Accessed via userLogin()  
- *View Events* (viewEvents())  
- *Book Ticket* (bookTicket())  
- *View My Tickets* (currentUser.viewBookedTickets())  
- *Cancel Ticket* (cancelTicket())  
- *Logout*

## Technical Details

### Prerequisites
- Java Development Kit (JDK 11 or above)  
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Project Structure
```text
src/
├── Main.java                 # Entry point & menu flow
├── User.java                 # User credentials & ticket list
├── Admin.java                # Admin extends User
├── Event.java                # Abstract base class
├── Cinema.java               # Event subtype
├── Concert.java
├── Theater.java
├── Exhibition.java
├── Festival.java
├── SportEvent.java
├── Venue.java                # Venue details & capacity
├── Seat.java                 # Seat model & booking flag
└── Ticket.java               # Links User, Event, and Seat

## Getting Started

1. Clone the repository
```bash
git clone https://github.com/selinx11/295
```

2. Open the project in your IDE

3. Run the Main.java file to start the application

4. Use the following default credentials for testing:
   - Admin: username: "idil", password: "idil123"
   - Admin: username: "selin", password: "selin123"
   - Admin: username: "aysegul ozkaya eren", password: "aysegulozkaya"
   - User: username: "pelin erkaya", password: "pelin123", e-mail: "pelinerkaya@gmail.com"

5. Then use functions of these users to use application.
