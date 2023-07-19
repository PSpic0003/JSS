package JobSeekingSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Create labels and fields
        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Create login button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            // Validate email and password
            boolean validLogin = validateLogin(email, password);

            if (validLogin) {
                // Check account type and navigate to the appropriate dashboard
                String accountType = getAccountType(email);
                if (accountType.equals("Job Seeker")) {
                    // Navigate to job seeker dashboard
                    navigateToJobSeekerDashboard();
                } else if (accountType.equals("Recruiter")) {
                    // Navigate to recruiter dashboard
                    navigateToRecruiterDashboard();
                }
            } else {
                showAlert("Invalid login credentials. Please try again.");
            }
        });

        // Create forgotten password link
        Hyperlink forgottenPasswordLink = new Hyperlink("Forgotten Password");
        forgottenPasswordLink.setOnAction(e -> showPasswordResetForm());

        // Create form layout
        GridPane formLayout = new GridPane();
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.setPadding(new Insets(20));
        formLayout.add(emailLabel, 0, 0);
        formLayout.add(emailField, 1, 0);
        formLayout.add(passwordLabel, 0, 1);
        formLayout.add(passwordField, 1, 1);
        formLayout.add(loginButton, 1, 2);
        formLayout.add(forgottenPasswordLink, 1, 3);

        // Create root layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleLabel, formLayout);

        // Create scene
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean validateLogin(String email, String password) {
        // Perform login validation logic here
        // Check if the email and password match a registered account
        // Return true if the login is valid, false otherwise
        // You can replace this with your actual login validation logic
        return email.equals("example@example.com") && password.equals("password");
    }

    private String getAccountType(String email) {
        // Perform account type retrieval logic here
        // Retrieve the account type associated with the email
        // Return the account type (e.g., "Job Seeker" or "Recruiter")
        // You can replace this with your actual account retrieval logic
        return "Job Seeker";
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateToJobSeekerDashboard() {
        // Perform navigation to the job seeker dashboard
        // This is just a placeholder method
        // Replace it with your actual navigation code
        System.out.println("Navigating to Job Seeker Dashboard...");
    }

    private void navigateToRecruiterDashboard() {
        // Perform navigation to the recruiter dashboard
        // This is just a placeholder method
        // Replace it with your actual navigation code
        System.out.println("Navigating to Recruiter Dashboard...");
    }

    private void showPasswordResetForm() {
        // Show the password reset form
        // This is just a placeholder method
        // Replace it with your actual code to show the password reset form
        System.out.println("Showing Password Reset Form...");
    }
}
