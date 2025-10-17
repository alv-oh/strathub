import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private static final String PROFILES_DIR = "data/profiles/";
    private static final String SAVED_EVENTS_DIR = "data/saved_events/";

    // Constructor - creates directories if they don't exist
    public FileManager() {
        new File(PROFILES_DIR).mkdirs();
        new File(SAVED_EVENTS_DIR).mkdirs();
    }

    // Save a student profile to file
    public void saveProfile(Student student) {
        String filename = PROFILES_DIR + sanitizeFilename(student.getName()) + ".txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("NAME:" + student.getName());
            writer.println("YEAR:" + student.getYear());
            writer.println("EMAIL:" + student.getEmail());
            
            // Save interests (comma-separated)
            ArrayList<String> interests = student.getInterests();
            writer.println("INTERESTS:" + String.join(",", interests));
            
            System.out.println("✓ Profile saved: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving profile: " + e.getMessage());
        }
    }

    // Load a student profile from file
    public Student loadProfile(String name) {
        String filename = PROFILES_DIR + sanitizeFilename(name) + ".txt";
        File file = new File(filename);
        
        if (!file.exists()) {
            System.out.println("Profile not found: " + name);
            return null;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Map<String, String> data = new HashMap<>();
            
            while ((line = reader.readLine()) != null) {
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    data.put(parts[0], parts.length > 1 ? parts[1] : "");
                }
            }
            
            String profileName = data.getOrDefault("NAME", "Unknown");
            int year = Integer.parseInt(data.getOrDefault("YEAR", "1"));
            String email = data.getOrDefault("EMAIL", "");
            
            // Parse interests
            ArrayList<String> interests = new ArrayList<>();
            String interestsStr = data.getOrDefault("INTERESTS", "");
            if (!interestsStr.isEmpty()) {
                for (String interest : interestsStr.split(",")) {
                    interests.add(interest.trim());
                }
            }
            
            System.out.println("✓ Profile loaded: " + profileName);
            return new Student(profileName, year, interests, email);
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading profile: " + e.getMessage());
            return null;
        }
    }

    // Get list of all saved profiles
    public ArrayList<String> getAllProfiles() {
        ArrayList<String> profiles = new ArrayList<>();
        File folder = new File(PROFILES_DIR);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        
        if (files != null) {
            for (File file : files) {
                String name = file.getName().replace(".txt", "");
                profiles.add(unsanitizeFilename(name));
            }
        }
        
        return profiles;
    }

    // Save saved events for a student
    public void saveSavedEvents(String studentName, ArrayList<Event> events) {
        String filename = SAVED_EVENTS_DIR + sanitizeFilename(studentName) + "_saved.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Event event : events) {
                writer.println(event.getTitle());
            }
            System.out.println("✓ Saved events stored");
        } catch (IOException e) {
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    // Save RSVP'd events for a student
    public void saveRsvpedEvents(String studentName, ArrayList<Event> events) {
        String filename = SAVED_EVENTS_DIR + sanitizeFilename(studentName) + "_rsvped.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Event event : events) {
                writer.println(event.getTitle());
            }
            System.out.println("✓ RSVP'd events stored");
        } catch (IOException e) {
            System.out.println("Error saving RSVP events: " + e.getMessage());
        }
    }

    // Helper: Sanitize filename (remove spaces, special chars)
    private String sanitizeFilename(String name) {
        return name.toLowerCase().replaceAll("[^a-z0-9]", "_");
    }

    // Helper: Reverse sanitize (restore original formatting - basic)
    private String unsanitizeFilename(String sanitized) {
        return sanitized.replace("_", " ");
    }
}