import java.util.ArrayList;

public class Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private ArrayList<String> tags;
    private String club;
    private String organizerEmail;
    private ArrayList<Student> attendees;

    // Constructor
    public Event(String title, String date, String time, String location, 
                 String description, ArrayList<String> tags, String club, String organizerEmail) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.tags = tags;
        this.club = club;
        this.organizerEmail = organizerEmail;
        this.attendees = new ArrayList<>();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getClub() {
        return club;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public ArrayList<Student> getAttendees() {
        return attendees;
    }

    // Add a student to attendees list
    public void addAttendee(Student student) {
        if (!attendees.contains(student)) {
            attendees.add(student);
        }
    }

    // Get full event details as a formatted string
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("\n========== EVENT DETAILS ==========\n");
        details.append("Title: ").append(title).append("\n");
        details.append("Date: ").append(date).append("\n");
        details.append("Time: ").append(time).append("\n");
        details.append("Location: ").append(location).append("\n");
        details.append("Club: ").append(club).append("\n");
        details.append("Description: ").append(description).append("\n");
        details.append("Tags: ").append(tags).append("\n");
        details.append("Organizer Email: ").append(organizerEmail).append("\n");
        details.append("Attendees: ").append(attendees.size()).append("\n");
        details.append("====================================\n");
        return details.toString();
    }

    // Check how many interests this event matches with a student
    public int matchScore(Student student) {
        int score = 0;
        ArrayList<String> studentInterests = student.getInterests();
        
        for (String interest : studentInterests) {
            if (tags.contains(interest)) {
                score++;
            }
        }
        return score;
    }

    @Override
    public String toString() {
        return title + " (" + date + " at " + location + ")";
    }
}