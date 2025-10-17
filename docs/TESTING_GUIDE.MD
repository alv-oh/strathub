# StrathHub Event Matcher - Testing Guide

## Overview

StrathHub is a personalized campus event recommendation system. It helps Strathmore students discover events based on their interests.

---

## How to Run the App

### Prerequisites

- Java installed on your computer
- Access to the project folder

### Steps

1. Open terminal/command prompt in the `strathub` folder
2. Compile: `javac -encoding UTF-8 src/*.java`
3. Run: `java -cp src Main`

You should see a welcome menu.

---

## Testing Workflow (15 minutes)

### 1. Create a New Profile (2 min)

- Choose option **1** from main menu
- Enter your name
- Enter your year (1, 2, 3, or 4)
- Enter your email
- Enter your interests (3-5, comma-separated)
  - Examples: `coding, sports, music` or `leadership, wellness, arts`

**What to look for:**

- Does the app accept your input?
- Does it say "Profile created successfully"?

---

### 2. Explore the Student Menu (1 min)

After login, you'll see a menu with 8 options. Review each one:

1. Browse All Events
2. Get Recommendations
3. View Saved Events
4. View RSVP'd Events
5. Search Events
6. View My Profile
7. Logout
8. Exit

---

### 3. Browse All Events (2 min)

- Choose option **1** from student menu
- View the full list of 12 Strathmore events
- Pick any event and view its details
- Try to **Save** it or **RSVP**

**What to look for:**

- Are event details clear?
- Does saving/RSVP work?
- Any confusing text or missing info?

---

### 4. Get Recommendations (3 min)

- Choose option **2** from student menu
- You should see your top 5 matching events

**What to look for:**

- Do the recommendations match your interests?
- Are they ordered logically?
- Pick one and save/RSVP to it

---

### 5. Search Events (2 min)

- Choose option **5** from student menu
- Search for a keyword (try: "sports", "music", "leadership")
- View results

**What to look for:**

- Does search work?
- Are results relevant?

---

### 6. View Saved/RSVP'd Events (1 min)

- Choose option **3** to view saved events
- Choose option **4** to view RSVP'd events
- You should see what you saved/RSVP'd to

**What to look for:**

- Do saved events show up?

---

### 7. Logout & Restart (Optional, 2 min)

- Choose option **7** to logout
- Choose option **8** to exit the app
- Run the app again: `java -cp src Main`
- Choose option **2** to login
- Select your profile
- Check if your saved/RSVP'd events are still there

**What to look for:**

- Does your profile load correctly?
- Is your data persistent?

---

## Feedback Form

Please answer the following after testing:

### 1. Ease of Use (1-5)

**1 = Very confusing | 5 = Very easy**

- How easy was it to create a profile? \_\_\_
- How easy was it to get recommendations? \_\_\_
- Overall app usability? \_\_\_

### 2. Recommendations Quality (1-5)

**1 = Not relevant | 5 = Perfect matches**

- Did the recommendations match your interests? \_\_\_
- Would you find this useful for discovering events? \_\_\_

### 3. Features (Check all that apply)

- [ ] Creating a profile was intuitive
- [ ] Getting recommendations was clear
- [ ] Saving/RSVP worked as expected
- [ ] Searching events was helpful
- [ ] The app feels polished

### 4. Issues & Suggestions

**What was confusing or didn't work?**
(If any bugs or unclear features, describe here)

**What feature would you most want added?**
(E.g., email notifications, calendar integration, etc.)

**Any other feedback?**

---

## Thank You!

Your feedback helps improve StrathHub. Please return this form to the developer once complete.
