import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Matcher {
    private ArrayList<Event> events;

    // Constructor
    public Matcher() {
        this.events = new ArrayList<>();
    }

    // Add an event to the database
    public void addEvent(Event event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }

    // Get all events
    public ArrayList<Event> getAllEvents() {
        return events;
    }

    // MAIN RECOMMENDATION METHOD
    // Returns top N events that match student interests
    public List<Event> recommend(Student student, int topN) {
        // Score each event based on how many interests match
        ArrayList<EventScore> scoredEvents = new ArrayList<>();

        for (Event event : events) {
            int score = event.matchScore(student);
            if (score > 0) { // Only include events with at least 1 match
                scoredEvents.add(new EventScore(event, score));
            }
        }

        // Sort by score in descending order (highest first)
        Collections.sort(scoredEvents, new Comparator<EventScore>() {
            @Override
            public int compare(EventScore e1, EventScore e2) {
                return Integer.compare(e2.score, e1.score); // Descending
            }
        });

        // Return top N events
        List<Event> recommendations = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, scoredEvents.size()); i++) {
            recommendations.add(scoredEvents.get(i).event);
        }

        return recommendations;
    }

    // Filter events by keyword (search functionality)
    public List<Event> filterByKeyword(String keyword) {
        ArrayList<Event> filtered = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Event event : events) {
            if (event.getTitle().toLowerCase().contains(lowerKeyword) ||
                event.getDescription().toLowerCase().contains(lowerKeyword) ||
                event.getClub().toLowerCase().contains(lowerKeyword)) {
                filtered.add(event);
            }
        }

        return filtered;
    }

    // Filter events by tag
    public List<Event> filterByTag(String tag) {
        ArrayList<Event> filtered = new ArrayList<>();

        for (Event event : events) {
            if (event.getTags().contains(tag)) {
                filtered.add(event);
            }
        }

        return filtered;
    }

    // Filter events by date
    public List<Event> filterByDate(String date) {
        ArrayList<Event> filtered = new ArrayList<>();

        for (Event event : events) {
            if (event.getDate().equals(date)) {
                filtered.add(event);
            }
        }

        return filtered;
    }

    // Get event count
    public int getEventCount() {
        return events.size();
    }

    // Inner class to pair events with their match scores
    private static class EventScore {
        Event event;
        int score;

        EventScore(Event event, int score) {
            this.event = event;
            this.score = score;
        }
    }
}