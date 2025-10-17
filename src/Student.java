import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> interests;
    private String email;
    private ArrayList<Event> savedEvents;
    private ArrayList<Event> rsvpedEvents;

    // Constructor
    public Student(String name, int year, ArrayList<String> interests, String email) {
        this.name = name;
        this.year = year;
        this.interests = interests;
        this.email = email;
        this.savedEvents = new ArrayList<>();
        this.rsvpedEvents = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Event> getSavedEvents() {
        return savedEvents;
    }

    public ArrayList<Event> getRsvpedEvents() {
        return rsvpedEvents;
    }

    // Add an interest
    public void addInterest(String interest) {
        if (!interests.contains(interest)) {
            interests.add(interest);
        }
    }

    // Save an event to favorites
    public void saveEvent(Event event) {
        if (!savedEvents.contains(event)) {
            savedEvents.add(event);
            System.out.println("✓ Event saved: " + event.getTitle());
        } else {
            System.out.println("⚠ Event already saved!");
        }
    }

    // RSVP to an event
    public void rsvpEvent(Event event) {
        if (!rsvpedEvents.contains(event)) {
            rsvpedEvents.add(event);
            event.addAttendee(this); // Add student to event's attendee list
            System.out.println("✓ RSVP confirmed: " + event.getTitle());
        } else {
            System.out.println("⚠ Already RSVP'd to this event!");
        }
    }

    // Display student profile
    public void displayProfile() {
        System.out.println("\n========== STUDENT PROFILE ==========");
        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("Email: " + email);
        System.out.println("Interests: " + interests);
        System.out.println("Saved Events: " + savedEvents.size());
        System.out.println("RSVP'd Events: " + rsvpedEvents.size());
        System.out.println("====================================\n");
    }

    @Override
    public String toString() {
        return name + " (Year " + year + ", " + interests.size() + " interests)";
    }
}