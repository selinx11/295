import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String adminId;
    private String username;
    private String password;
    private List<Event> createdEvents = new ArrayList<>();

    public Admin(String adminId, String username, String password) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public String getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public void addEvent(Event event) {
        createdEvents.add(event);
    }

    public void removeEvent(Event event) {
        createdEvents.remove(event);
    }
}

