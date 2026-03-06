public class LoginWindow extends Application {
    private FileManager fileManager;
    private Matcher matcher;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.fileManager = new FileManager();
        this.matcher = new Matcher();

        // Initialize with 12 Strathmore events
        initializeEvents();

        primaryStage.setTitle("StrathHub Event Matcher");
        showLoginScreen();
        primaryStage.show();
    }

    private void initializeEvents() {
        // Event 1: Nairobi Open Day
        ArrayList<String> tags1 = new ArrayList<>();
        tags1.add("campus_tour");
        tags1.add("community");
        tags1.add("networking");
        matcher.addEvent(new Event("Nairobi Open Day", "January 18, 2025", "9:00 AM", "Main Campus",
                "Prospective and current students explore programs and campus opportunities.",
                tags1, "Admissions Office", "admissions@strathmore.ac.ke"));

        // Event 2: International Women's Day
        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("community");
        tags2.add("social_impact");
        tags2.add("leadership");
        tags2.add("inclusivity");
        matcher.addEvent(new Event("International Women's Day Celebrations", "March 6, 2025", "10:00 AM", "Student Center",
                "Activities and service opportunities involving the student body.",
                tags2, "Student Council", "council@strathmore.ac.ke"));

        // Event 3: VC Run
        ArrayList<String> tags3 = new ArrayList<>();
        tags3.add("sports");
        tags3.add("fitness");
        tags3.add("fun");
        tags3.add("wellness");
        tags3.add("community");
        matcher.addEvent(new Event("VC Run", "May 31, 2025", "6:00 AM", "Campus Grounds",
                "A fun run event engaging students across the university.",
                tags3, "Sports Department", "sports@strathmore.ac.ke"));

        // Event 4: Graduation
        ArrayList<String> tags4 = new ArrayList<>();
        tags4.add("celebration");
        tags4.add("academic");
        tags4.add("achievement");
        tags4.add("community");
        matcher.addEvent(new Event("Graduation", "June 26-27, 2025", "10:00 AM", "Main Hall",
                "The main academic celebration for final-year students.",
                tags4, "Academic Affairs", "academic@strathmore.ac.ke"));

        // Event 5: Leadership Hike
        ArrayList<String> tags5 = new ArrayList<>();
        tags5.add("outdoor");
        tags5.add("leadership");
        tags5.add("team_building");
        tags5.add("wellness");
        matcher.addEvent(new Event("Leadership Hike", "July 18, 2025", "7:00 AM", "Outdoor",
                "Targets student leaders in leadership development activities.",
                tags5, "Student Leadership", "leadership@strathmore.ac.ke"));

        // Event 6: Sports Day
        ArrayList<String> tags6 = new ArrayList<>();
        tags6.add("sports");
        tags6.add("competition");
        tags6.add("fitness");
        tags6.add("athletics");
        tags6.add("team_spirit");
        matcher.addEvent(new Event("Sports Day", "August 29, 2025", "8:00 AM", "Sports Complex",
                "Promotes active student participation in athletics and games.",
                tags6, "Sports Department", "sports@strathmore.ac.ke"));

        // Event 7: Wellness Fair
        ArrayList<String> tags7 = new ArrayList<>();
        tags7.add("wellness");
        tags7.add("health");
        tags7.add("self_care");
        tags7.add("community");
        matcher.addEvent(new Event("Wellness Fair", "September 12, 2025", "10:00 AM", "Student Center",
                "Focused on student health and well-being.",
                tags7, "Health Services", "health@strathmore.ac.ke"));

        // Event 8: New Students' Convocation
        ArrayList<String> tags8 = new ArrayList<>();
        tags8.add("welcome");
        tags8.add("orientation");
        tags8.add("networking");
        tags8.add("community");
        matcher.addEvent(new Event("New Students' Convocation", "September 26, 2025", "9:00 AM", "Main Hall",
                "Welcomes and orients new students.",
                tags8, "Student Affairs", "affairs@strathmore.ac.ke"));

        // Event 9: Founder's Week
        ArrayList<String> tags9 = new ArrayList<>();
        tags9.add("conference");
        tags9.add("learning");
        tags9.add("leadership");
        tags9.add("networking");
        tags9.add("inspiration");
        matcher.addEvent(new Event("Founder's Week & Be Do Care Conference", "September 29 - October 3, 2025", "9:00 AM", "Various",
                "Includes student-centered forums and discussions.",
                tags9, "Administration", "admin@strathmore.ac.ke"));

        // Event 10: Alumni Connect
        ArrayList<String> tags10 = new ArrayList<>();
        tags10.add("networking");
        tags10.add("career");
        tags10.add("mentorship");
        tags10.add("professional_development");
        matcher.addEvent(new Event("Annual Alumni Connect", "October 4, 2025", "2:00 PM", "Campus",
                "Includes networking for current students and alumni.",
                tags10, "Alumni Affairs", "alumni@strathmore.ac.ke"));

        // Event 11: SI Graduation
        ArrayList<String> tags11 = new ArrayList<>();
        tags11.add("celebration");
        tags11.add("academic");
        tags11.add("achievement");
        matcher.addEvent(new Event("Strathmore Instituteimport javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

        public class LoginWindow extends Application {
            private FileManager fileManager;
            private Stage primaryStage;

            @Override
            public void start(Stage primaryStage) {
                this.primaryStage = primaryStage;
                this.fileManager = new FileManager();

                primaryStage.setTitle("StrathHub Event Matcher");
                showLoginScreen();
                primaryStage.show();
            }

            private void showLoginScreen() {
                // Main container
                VBox root = new VBox(20);
                root.setPadding(new Insets(40));
                root.setAlignment(Pos.CENTER);
                root.setStyle("-fx-background-color: #f5f5f5;");

                // Title
                Label titleLabel = new Label("StrathHub Event Matcher");
                titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
                titleLabel.setStyle("-fx-text-fill: #2c3e50;");

                Label subtitleLabel = new Label("Your Personal Campus Event Assistant");
                subtitleLabel.setFont(Font.font("Arial", 14));
                subtitleLabel.setStyle("-fx-text-fill: #7f8c8d;");

                // Welcome message
                Label welcomeLabel = new Label("Welcome! Please login or create a new profile.");
                welcomeLabel.setFont(Font.font("Arial", 12));
                welcomeLabel.setStyle("-fx-text-fill: #34495e;");

                // Buttons
                Button loginButton = new Button("Login to Existing Profile");
                loginButton.setPrefWidth(250);
                loginButton.setPrefHeight(40);
                loginButton.setStyle(
                        "-fx-background-color: #3498db; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-background-radius: 5;"
                );
                loginButton.setOnMouseEntered(e ->
                        loginButton.setStyle(
                                "-fx-background-color: #2980b9; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-font-weight: bold; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                loginButton.setOnMouseExited(e ->
                        loginButton.setStyle(
                                "-fx-background-color: #3498db; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-font-weight: bold; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                loginButton.setOnAction(e -> showProfileSelection());

                Button createButton = new Button("Create New Profile");
                createButton.setPrefWidth(250);
                createButton.setPrefHeight(40);
                createButton.setStyle(
                        "-fx-background-color: #2ecc71; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-background-radius: 5;"
                );
                createButton.setOnMouseEntered(e ->
                        createButton.setStyle(
                                "-fx-background-color: #27ae60; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-font-weight: bold; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                createButton.setOnMouseExited(e ->
                        createButton.setStyle(
                                "-fx-background-color: #2ecc71; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-font-weight: bold; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                createButton.setOnAction(e -> showCreateProfile());

                Button exitButton = new Button("Exit");
                exitButton.setPrefWidth(250);
                exitButton.setPrefHeight(40);
                exitButton.setStyle(
                        "-fx-background-color: #95a5a6; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 14px; " +
                                "-fx-background-radius: 5;"
                );
                exitButton.setOnMouseEntered(e ->
                        exitButton.setStyle(
                                "-fx-background-color: #7f8c8d; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                exitButton.setOnMouseExited(e ->
                        exitButton.setStyle(
                                "-fx-background-color: #95a5a6; " +
                                        "-fx-text-fill: white; " +
                                        "-fx-font-size: 14px; " +
                                        "-fx-background-radius: 5;"
                        )
                );
                exitButton.setOnAction(e -> primaryStage.close());

                // Add spacing
                Region spacer1 = new Region();
                spacer1.setPrefHeight(20);
                Region spacer2 = new Region();
                spacer2.setPrefHeight(10);

                // Add all elements
                root.getChildren().addAll(
                        titleLabel,
                        subtitleLabel,
                        spacer1,
                        welcomeLabel,
                        spacer2,
                        loginButton,
                        createButton,
                        exitButton
                );

                Scene scene = new Scene(root, 600, 500);
                primaryStage.setScene(scene);
            }

            private void showProfileSelection() {
                ArrayList<String> profiles = fileManager.getAllProfiles();

                if (profiles.isEmpty()) {
                    showAlert("No Profiles Found", "No profiles found. Please create a new profile first.", Alert.AlertType.INFORMATION);
                    return;
                }

                // Create profile selection dialog
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Select Profile");

                VBox dialogRoot = new VBox(15);
                dialogRoot.setPadding(new Insets(20));
                dialogRoot.setAlignment(Pos.CENTER);

                Label label = new Label("Select your profile:");
                label.setFont(Font.font("Arial", FontWeight.BOLD, 14));

                ListView<String> listView = new ListView<>();
                listView.getItems().addAll(profiles);
                listView.setPrefHeight(200);

                Button selectButton = new Button("Login");
                selectButton.setStyle(
                        "-fx-background-color: #3498db; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-weight: bold;"
                );
                selectButton.setOnAction(e -> {
                    String selected = listView.getSelectionModel().getSelectedItem();
                    if (selected != null) {
                        Student student = fileManager.loadProfile(selected);
                        if (student != null) {
                            dialogStage.close();
                            showMainMenu(student);
                        }
                    } else {
                        showAlert("No Selection", "Please select a profile.", Alert.AlertType.WARNING);
                    }
                });

                Button cancelButton = new Button("Cancel");
                cancelButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white;");
                cancelButton.setOnAction(e -> dialogStage.close());

                HBox buttonBox = new HBox(10);
                buttonBox.setAlignment(Pos.CENTER);
                buttonBox.getChildren().addAll(selectButton, cancelButton);

                dialogRoot.getChildren().addAll(label, listView, buttonBox);

                Scene dialogScene = new Scene(dialogRoot, 400, 350);
                dialogStage.setScene(dialogScene);
                dialogStage.show();
            }

            private void showCreateProfile() {
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Create New Profile");

                GridPane grid = new GridPane();
                grid.setPadding(new Insets(20));
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setAlignment(Pos.CENTER);

                // Form fields
                Label nameLabel = new Label("Name:");
                TextField nameField = new TextField();

                Label yearLabel = new Label("Year (1-4):");
                ComboBox<Integer> yearCombo = new ComboBox<>();
                yearCombo.getItems().addAll(1, 2, 3, 4);
                yearCombo.setValue(1);

                Label emailLabel = new Label("Email:");
                TextField emailField = new TextField();

                Label interestsLabel = new Label("Interests:");
                TextField interestsField = new TextField();
                interestsField.setPromptText("e.g., coding, sports, music");

                grid.add(nameLabel, 0, 0);
                grid.add(nameField, 1, 0);
                grid.add(yearLabel, 0, 1);
                grid.add(yearCombo, 1, 1);
                grid.add(emailLabel, 0, 2);
                grid.add(emailField, 1, 2);
                grid.add(interestsLabel, 0, 3);
                grid.add(interestsField, 1, 3);

                Button createButton = new Button("Create Profile");
                createButton.setStyle(
                        "-fx-background-color: #2ecc71; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-weight: bold;"
                );
                createButton.setOnAction(e -> {
                    String name = nameField.getText().trim();
                    Integer year = yearCombo.getValue();
                    String email = emailField.getText().trim();
                    String interestsStr = interestsField.getText().trim();

                    if (name.isEmpty() || email.isEmpty() || interestsStr.isEmpty()) {
                        showAlert("Incomplete Form", "Please fill in all fields.", Alert.AlertType.WARNING);
                        return;
                    }

                    ArrayList<String> interests = new ArrayList<>();
                    for (String interest : interestsStr.split(",")) {
                        interests.add(interest.trim().toLowerCase());
                    }

                    Student student = new Student(name, year, interests, email);
                    fileManager.saveProfile(student);

                    dialogStage.close();
                    showAlert("Success", "Profile created successfully! Welcome, " + name + "!", Alert.AlertType.INFORMATION);
                    showMainMenu(student);
                });

                Button cancelButton = new Button("Cancel");
                cancelButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white;");
                cancelButton.setOnAction(e -> dialogStage.close());

                HBox buttonBox = new HBox(10);
                buttonBox.setAlignment(Pos.CENTER);
                buttonBox.getChildren().addAll(createButton, cancelButton);

                grid.add(buttonBox, 0, 4, 2, 1);

                Scene dialogScene = new Scene(grid, 450, 300);
                dialogStage.setScene(dialogScene);
                dialogStage.show();
            }

            private void showMainMenu(Student student) {
                // Placeholder for main menu - we'll build this next
                showAlert("Coming Soon", "Main menu with events will be implemented next!", Alert.AlertType.INFORMATION);
                // TODO: Create MainMenuWindow with events, recommendations, etc.
            }

            private void showAlert(String title, String message, Alert.AlertType type) {
                Alert alert = new Alert(type);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.showAndWait();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }