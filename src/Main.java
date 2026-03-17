import person.Person;
import person.Staff;
import person.Student;
import ticket.CleaningTicket;
import ticket.MaintenanceTicket;
import ticket.Ticket;

static List<Person> persons = new ArrayList<>();
static List<Ticket> tickets = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

void main() {

    while (true) {
        IO.println("\n--- CampusCare Menu ---");
        IO.println("1. Add Person");
        IO.println("2. Create Ticket");
        IO.println("3. View All Tickets");
        IO.println("4. Update Ticket Status");
        IO.println("5. Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                addPerson();
                break;
            case 2:
                createTicket();
                break;
            case 3:
                viewTickets();
                break;
            case 4:
                updateStatus();
                break;
            case 5:
                IO.println("Exiting...");
                return;
            default:
                IO.println("Invalid choice!");
        }
    }
}

// 🔹 Add Person
public static void addPerson() {
    IO.println("1. Student\n2. Staff");
    int type = sc.nextInt();
    sc.nextLine();

    IO.print("Enter ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    IO.print("Enter Name: ");
    String name = sc.nextLine();

    IO.print("Enter Email: ");
    String email = sc.nextLine();

    if (type == 1) {
        IO.print("Program: ");
        String program = sc.nextLine();

        IO.print("Semester: ");
        int semester = sc.nextInt();

        persons.add(new Student(id, name, email, program, semester));

    } else {
        IO.print("Department: ");
        String dept = sc.nextLine();

        persons.add(new Staff(id, name, email, dept));
    }

    IO.println("Person added!");
}

// 🔹 Create Ticket
public static void createTicket() {
    IO.println("1. Maintenance\n2. Cleaning");
    int type = sc.nextInt();
    sc.nextLine();

    IO.print("Ticket ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    IO.print("Title: ");
    String title = sc.nextLine();

    IO.print("Description: ");
    String desc = sc.nextLine();

    IO.print("Location: ");
    String loc = sc.nextLine();

    IO.print("Type: ");
    String t = sc.nextLine();

    if (type == 1) {
        tickets.add(new MaintenanceTicket(id, title, desc, loc, t));
    } else {
        tickets.add(new CleaningTicket(id, title, desc, loc, t));
    }

    IO.println("Ticket created!");
}

// 🔹 View Tickets
public static void viewTickets() {
    for (Ticket t : tickets) {
        IO.println("ID: " + t.getTicketId() +
                " | Status: " + t.getStatus() +
                " | Priority: " + t.priorityScore());
    }
}

// 🔹 Update Status
public static void updateStatus() {
    IO.print("Enter Ticket ID: ");
    int id = sc.nextInt();

    for (Ticket t : tickets) {
        if (t.getTicketId() == id) {

            IO.println("1. New\n2. Assigned\n3. Resolved");
            int s = sc.nextInt();

            if (s == 1) t.setStatus("New");
            else if (s == 2) t.setStatus("Assigned");
            else t.setStatus("Resolved");

            IO.println("Status Updated!");
            return;
        }
    }

    IO.println("Ticket not found!");
}