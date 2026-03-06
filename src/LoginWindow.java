import javafx.application.Application;
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