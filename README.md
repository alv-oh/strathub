# StrathHub Event Matcher

**A Personalized Campus Event Recommendation System for Strathmore University**

---

## 📋 Project Overview

StrathHub is a Java-based application that helps Strathmore University students discover relevant campus events based on their interests. The app solves the problem of event information overload by providing intelligent, personalized recommendations.

### Problem Statement
New students at Strathmore often miss out on campus events due to:
- Information scattered across multiple platforms
- Uncertainty about event timing and location
- No clear follow-up communication from organizers
- Difficulty finding events that match their interests

### Solution
StrathHub matches students to events based on their interests, making event discovery easier and more engaging.

---

## ✨ Features

### MVP (Completed)
- ✅ Create and manage student profiles (name, year, interests, email)
- ✅ Browse all 12 campus events with detailed information
- ✅ Get personalized event recommendations based on interest matching
- ✅ Save favorite events
- ✅ RSVP to events and track attendance
- ✅ Search events by keyword
- ✅ Persistent data storage (profiles survive app restarts)
- ✅ Login system for returning users

### Future Enhancements
- Email notifications for upcoming events
- Calendar integration (Google Calendar export)
- Advanced ML-based recommendations
- Web/mobile interface
- Admin dashboard for event management
- User ratings and reviews

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher installed
- Git (optional, for cloning)
- Command line/terminal access

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/alv-oh/strathub.git
   cd strathub
   ```

2. **Compile the application:**
   ```bash
   javac -encoding UTF-8 src/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp src Main
   ```

---

## 📖 Usage Guide

### Main Menu
When you start the app, you'll see:
```
========== MAIN MENU ==========
1. Create New Student Profile
2. Login to Existing Profile
3. Exit
```

### Creating a Profile
1. Choose option **1**
2. Enter your name, year (1-4), email
3. Enter your interests (comma-separated, e.g., "coding, sports, music")
4. Profile is saved automatically

### Getting Recommendations
1. Login to your profile
2. Choose **2. Get Recommendations**
3. View your top 5 events matching your interests
4. Select an event to see full details
5. Save or RSVP to events

### Other Features
- **Browse All Events**: View all 12 Strathmore events
- **Search Events**: Find events by keyword (e.g., "sports", "leadership")
- **View Saved Events**: See all events you've bookmarked
- **View RSVP'd Events**: See events you've confirmed attendance for
- **View Profile**: Check your profile information

---

## 🏗️ Architecture

### Core Classes

**Student.java**
- Manages student profiles
- Stores interests, saved events, RSVP'd events
- Methods: `saveEvent()`, `rsvpEvent()`, `getInterests()`

**Event.java**
- Represents campus events
- Stores event details (title, date, time, location, tags)
- Methods: `getDetails()`, `matchScore()`, `addAttendee()`

**Matcher.java**
- The recommendation engine
- Scores and ranks events based on student interests
- Methods: `recommend()`, `filterByKeyword()`, `filterByTag()`, `filterByDate()`

**FileManager.java**
- Handles persistent data storage
- Saves/loads student profiles
- Manages saved and RSVP'd events
- Methods: `saveProfile()`, `loadProfile()`, `getAllProfiles()`

**StrathHub.java**
- Main application coordinator
- Manages user interaction and menu flow
- Initializes 12 Strathmore events
- Methods: `run()`, `displayMainMenu()`, `createNewStudent()`, `loginStudent()`

**Main.java**
- Application entry point
- Starts the StrathHub application

### Data Flow
```
User Input → StrathHub Menu → Student/Event/Matcher Logic → FileManager → Disk Storage
```

---

## 📊 Sample Events

StrathHub includes 12 real Strathmore University events:

1. Nairobi Open Day (Jan 18)
2. International Women's Day (Mar 6)
3. VC Run (May 31)
4. Graduation (Jun 26-27)
5. Leadership Hike (Jul 18)
6. Sports Day (Aug 29)
7. Wellness Fair (Sep 12)
8. New Students' Convocation (Sep 26)
9. Founder's Week & Be Do Care Conference (Sep 29-Oct 3)
10. Annual Alumni Connect (Oct 4)
11. Strathmore Institute Graduation (Oct 24)
12. Strathmore Benefit Concert (Nov 15)

Each event has tags (interests) like "coding", "sports", "leadership", "wellness", etc.

---

## 💾 File Structure

```
strathub/
├── src/
│   ├── Main.java              # Entry point
│   ├── StrathHub.java         # Main app coordinator
│   ├── Student.java           # Student profile class
│   ├── Event.java             # Event class
│   ├── Matcher.java           # Recommendation engine
│   └── FileManager.java       # File I/O & persistence
├── data/
│   ├── profiles/              # Saved student profiles
│   └── saved_events/          # Saved/RSVP'd events
├── docs/
│   ├── TESTING_GUIDE.md       # User testing documentation
│   ├── UML_Diagram.png        # Class diagram
│   └── Week1_Design.md        # Design notes
├── README.md                  # This file
└── .gitignore
```

---

## 🧪 Testing

### User Testing
See `docs/TESTING_GUIDE.md` for detailed testing instructions.

### How to Test
1. Compile and run the app
2. Create multiple profiles with different interests
3. Test getting recommendations
4. Save/RSVP to events
5. Logout and log back in to verify persistence
6. Test search functionality

### Test Results
✅ All features working  
✅ File persistence verified  
✅ User feedback: "Comprehensive"  
✅ No critical bugs found

---

## 📈 Development Timeline

| Phase | Timeline | Status |
|-------|----------|--------|
| Week 1 | Research & Design | ✅ Complete |
| Week 2 | Core Logic & Console App | ✅ Complete |
| Week 3 | File I/O & User Testing | ✅ Complete |
| Week 4 | Polish & Documentation | 🔄 In Progress |
| Year 1 Sem 2 | JavaFX GUI | 📅 Planned |
| Year 2-3 | Web Version & Advanced Features | 📅 Planned |

---

## 🔮 Future Roadmap

**Short Term (Semester 2)**
- Add JavaFX graphical user interface
- Implement email notifications
- Add event filtering by date/club

**Medium Term (Year 2)**
- Convert to web application (Spring Boot backend)
- Integrate with Strathmore's official calendar
- Add user ratings and reviews system
- Mobile app (Android/iOS)

**Long Term (Year 3)**
- Machine learning for improved recommendations
- Integration with external event platforms
- Advanced analytics dashboard
- Event creation by student organizations

---

## 👨‍💻 Developer

**Name:** Alvin  
**University:** Strathmore University  
**Course:** Computer Science, Year 1  
**Email:** alv-oh@github.com

---

## 📝 License

This project is created as part of a Computer Science curriculum at Strathmore University.

---

## 🙏 Acknowledgments

- Strathmore University for providing the context and event data
- Classmates who participated in user testing
- Professors guiding the project development

---

## 📞 Support

For issues, questions, or feedback:
- Open an issue on GitHub
- Contact the developer

---

**Last Updated:** November 2025  
**Status:** MVP Complete & Tested