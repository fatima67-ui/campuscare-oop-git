package person;

public class Person {
    private String name;
    private String email;

    // Constructor
    public Person(int id, String name, String email) {
        this.name = name;
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email! '@' missing.");
        }
    }
}