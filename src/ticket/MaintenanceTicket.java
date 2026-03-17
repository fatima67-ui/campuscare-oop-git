package ticket;

public class MaintenanceTicket extends Ticket {

    public MaintenanceTicket(int ticketId, String title, String description, String location, String type) {
        super(ticketId, title, description, location);
        // Chair / Desk / Window / Board
    }

    @Override
    public double priorityScore() {
        double score = 5.0;

        // agar location mein "lab" ho
        if (location.toLowerCase().contains("lab")) {
            score += 5;
        }

        return score;
    }
}