package ticket;

public class CleaningTicket extends Ticket {

    public CleaningTicket(int ticketId, String title, String description, String location, String type) {
        super(ticketId, title, description, location);
        // Trash / Dirty Area
    }

    @Override
    public double priorityScore() {
        double score = 3.0;

        // agar description mein "trash" ho
        if (description.toLowerCase().contains("trash")) {
            score += 7;
        }

        return score;
    }
}