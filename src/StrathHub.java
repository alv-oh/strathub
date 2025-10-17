import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrathHub {
    private ArrayList<Student> students;
    private Matcher matcher;
    private Scanner scanner;
    private Student currentStudent;

    // Constructor
    public StrathHub() {
        this.students = new ArrayList<>();
        this.matcher = new Matcher();
        this.scanner = new Scanner(System.in);
        this.currentStudent = null;
        initializeEvents(); // Load sample events
    }

    // Initialize with your 12 real events
    private void initializeEvents() {
        // Event 1: Nairobi Open Day
        ArrayList<String> tags1 = new ArrayList<>();
        tags1.add("campus_tour");
        tags1.add("community");
        tags1.add("networking");
        Event e1 = new Event("Nairobi Open Day", "January 18, 2025", "9:00 AM", "Main Campus",
                "Prospective and current students explore programs and campus opportunities.",
                tags1, "Admissions Office", "admissions@strathmore.ac.ke");
        matcher.addEvent(e1);

        // Event 2: International Women's Day
        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("community");
        tags2.add("social_impact");
        tags2.add("leadership");
        tags2.add("inclusivity");
        Event e2 = new Event("International Women's Day Celebrations", "March 6, 2025", "10:00 AM", "Student Center",
                "Activities and service opportunities involving the student body.",
                tags2, "Student Council", "council@strathmore.ac.ke");
        matcher.addEvent(e2);

        // Event 3: VC Run
        ArrayList<String> tags3 = new ArrayList<>();
        tags3.add("sports");
        tags3.add("fitness");
        tags3.add("fun");
        tags3.add("wellness");
        tags3.add("community");
        Event e3 = new Event("VC Run", "May 31, 2025", "6:00 AM", "Campus Grounds",
                "A fun run event engaging students across the university.",
                tags3, "Sports Department", "sports@strathmore.ac.ke");
        matcher.addEvent(e3);

        // Event 4: Graduation
        ArrayList<String> tags4 = new ArrayList<>();
        tags4.add("celebration");
        tags4.add("academic");
        tags4.add("achievement");
        tags4.add("community");
        Event e4 = new Event("Graduation", "June 26-27, 2025", "10:00 AM", "Main Hall",
                "The main academic celebration for final-year students.",
                tags4, "Academic Affairs", "academic@strathmore.ac.ke");
        matcher.addEvent(e4);

        // Event 5: Leadership Hike
        ArrayList<String> tags5 = new ArrayList<>();
        tags5.add("outdoor");
        tags5.add("leadership");
        tags5.add("team_building");
        tags5.add("wellness");
        Event e5 = new Event("Leadership Hike", "July 18, 2025", "7:00 AM", "Outdoor",
                "Targets student leaders in leadership development activities.",
                tags5, "Student Leadership", "leadership@strathmore.ac.ke");
        matcher.addEvent(e5);

        // Event 6: Sports Day
        ArrayList<String> tags6 = new ArrayList<>();
        tags6.add("sports");
        tags6.add("competition");
        tags6.add("fitness");
        tags6.add("athletics");
        tags6.add("team_spirit");
        Event e6 = new Event("Sports Day", "August 29, 2025", "8:00 AM", "Sports Complex",
                "Promotes active student participation in athletics and games.",
                tags6, "Sports Department", "sports@strathmore.ac.ke");
        matcher.addEvent(e6);

        // Event 7: Wellness Fair
        ArrayList<String> tags7 = new ArrayList<>();
        tags7.add("wellness");
        tags7.add("health");
        tags7.add("self_care");
        tags7.add("community");
        Event e7 = new Event("Wellness Fair", "September 12, 2025", "10:00 AM", "Student Center",
                "Focused on student health and well-being.",
                tags7, "Health Services", "health@strathmore.ac.ke");
        matcher.addEvent(e7);

        // Event 8: New Students' Convocation
        ArrayList<String> tags8 = new ArrayList<>();
        tags8.add("welcome");
        tags8.add("orientation");
        tags8.add("networking");
        tags8.add("community");
        Event e8 = new Event("New Students' Convocation", "September 26, 2025", "9:00 AM", "Main Hall",
                "Welcomes and orients new students.",
                tags8, "Student Affairs", "affairs@strathmore.ac.ke");
        matcher.addEvent(e8);

        // Event 9: Founder's Week & Be Do Care Conference
        ArrayList<String> tags9 = new ArrayList<>();
        tags9.add("conference");
        tags9.add("learning");
        tags9.add("leadership");
        tags9.add("networking");
        tags9.add("inspiration");
        Event e9 = new Event("Founder's Week & Be Do Care Conference", "September 29 - October 3, 2025", "9:00 AM", "Various",
                "Includes student-centered forums and discussions.",
                tags9, "Administration", "admin@strathmore.ac.ke");
        matcher.addEvent(e9);

        // Event 10: Annual Alumni Connect
        ArrayList<String> tags10 = new ArrayList<>();
        tags10.add("networking");
        tags10.add("career");
        tags10.add("mentorship");
        tags10.add("professional_development");
        Event e10 = new Event("Annual Alumni Connect", "October 4, 2025", "2:00 PM", "Campus",
                "Includes networking for current students and alumni.",
                tags10, "Alumni Affairs", "alumni@strathmore.ac.ke");
        matcher.addEvent(e10);

        // Event 11: Strathmore Institute Graduation
        ArrayList<String> tags11 = new ArrayList<>();
        tags11.add("celebration");
        tags11.add("academic");
        tags11.add("achievement");
        Event e11 = new Event("Strathmore Institute Graduation", "October 24, 2025", "10:00 AM", "Main Hall",
                "Graduation day for Strathmore Institute students.",
                tags11, "SI Administration", "si@strathmore.ac.ke");
        matcher.addEvent(e11);

        // Event 12: Strathmore Benefit Concert
        ArrayList<String> tags12 = new ArrayList<>();
        tags12.add("music");
        tags12.add("entertainment");
        tags12.add("performance");
        tags12.add("community");
        tags12.add("fun");
        Event e12 = new Event("Strathmore Benefit Concert", "November 15, 2025", "6:00 PM", "Main Auditorium",
                "Features student performances and participation.",
                tags12, "Student Council", "council@strathmore.ac.ke");
        matcher.addEvent(e12);
    }

    // Main menu
    public void run() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    Welcome to StrathHub Event Matcher   ║");
        System.out.println("║  Your Personal Campus Event Assistant  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        boolean running = true;
        while (running) {
            if (currentStudent == null) {
                displayMainMenu();
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        createNewStudent();
                        break;
                    case "2":
                        running = false;
                        System.out.println("Thank you for using StrathHub. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                displayStudentMenu();
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        browseAllEvents();
                        break;
                    case "2":
                        getRecommendations();
                        break;
                    case "3":
                        viewSavedEvents();
                        break;
                    case "4":
                        viewRsvpedEvents();
                        break;
                    case "5":
                        searchEvents();
                        break;
                    case "6":
                        currentStudent.displayProfile();
                        break;
                    case "7":
                        currentStudent = null;
                        System.out.println("Logged out successfully.\n");
                        break;
                    case "8":
                        running = false;
                        System.out.println("Thank you for using StrathHub!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Create New Student Profile");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
    }

    private void displayStudentMenu() {
        System.out.println("\n========== STUDENT MENU ==========");
        System.out.println("1. Browse All Events");
        System.out.println("2. Get Recommendations");
        System.out.println("3. View Saved Events");
        System.out.println("4. View RSVP'd Events");
        System.out.println("5. Search Events");
        System.out.println("6. View My Profile");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    private void createNewStudent() {
        System.out.println("\n========== CREATE PROFILE ==========");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Year (1-4): ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Interests (comma-separated, e.g., 'coding, sports, music'): ");
        String interestsStr = scanner.nextLine();
        ArrayList<String> interests = new ArrayList<>();
        for (String interest : interestsStr.split(",")) {
            interests.add(interest.trim().toLowerCase());
        }

        currentStudent = new Student(name, year, interests, email);
        System.out.println("\nProfile created successfully! Welcome, " + name + "!\n");
    }

    private void browseAllEvents() {
        System.out.println("\n========== ALL EVENTS ==========");
        ArrayList<Event> allEvents = matcher.getAllEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println((i + 1) + ". " + allEvents.get(i));
        }

        System.out.print("\nEnter event number to view details (or 0 to go back): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= allEvents.size()) {
            Event selected = allEvents.get(choice - 1);
            System.out.println(selected.getDetails());

            System.out.println("1. Save Event");
            System.out.println("2. RSVP to Event");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            String action = scanner.nextLine().trim();

            if (action.equals("1")) {
                currentStudent.saveEvent(selected);
            } else if (action.equals("2")) {
                currentStudent.rsvpEvent(selected);
            }
        }
    }

    private void getRecommendations() {
        System.out.println("\n========== YOUR RECOMMENDATIONS ==========");
        List<Event> recommendations = matcher.recommend(currentStudent, 5);

        if (recommendations.isEmpty()) {
            System.out.println("No matching events found based on your interests.");
        } else {
            System.out.println("Top " + recommendations.size() + " events for you:\n");
            for (int i = 0; i < recommendations.size(); i++) {
                System.out.println((i + 1) + ". " + recommendations.get(i));
            }

            System.out.print("\nEnter event number to view details (or 0 to go back): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 0 && choice <= recommendations.size()) {
                Event selected = recommendations.get(choice - 1);
                System.out.println(selected.getDetails());

                System.out.println("1. Save Event");
                System.out.println("2. RSVP to Event");
                System.out.println("3. Back");
                System.out.print("Choose: ");
                String action = scanner.nextLine().trim();

                if (action.equals("1")) {
                    currentStudent.saveEvent(selected);
                } else if (action.equals("2")) {
                    currentStudent.rsvpEvent(selected);
                }
            }
        }
    }

    private void viewSavedEvents() {
        System.out.println("\n========== SAVED EVENTS ==========");
        ArrayList<Event> saved = currentStudent.getSavedEvents();

        if (saved.isEmpty()) {
            System.out.println("You haven't saved any events yet.");
        } else {
            for (int i = 0; i < saved.size(); i++) {
                System.out.println((i + 1) + ". " + saved.get(i));
            }
        }
    }

    private void viewRsvpedEvents() {
        System.out.println("\n========== RSVP'D EVENTS ==========");
        ArrayList<Event> rsvped = currentStudent.getRsvpedEvents();

        if (rsvped.isEmpty()) {
            System.out.println("You haven't RSVP'd to any events yet.");
        } else {
            for (int i = 0; i < rsvped.size(); i++) {
                System.out.println((i + 1) + ". " + rsvped.get(i));
            }
        }
    }

    private void searchEvents() {
        System.out.print("\nSearch for events (keyword): ");
        String keyword = scanner.nextLine();

        List<Event> results = matcher.filterByKeyword(keyword);

        if (results.isEmpty()) {
            System.out.println("No events found matching '" + keyword + "'");
        } else {
            System.out.println("\nSearch Results:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
    }
}