package JobSeekingSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegistrationPage extends Application {

    private TextField emailField;
    private TextField firstNameField;
    private TextField lastNameField;
    private PasswordField passwordField;
    private ComboBox<String> accountTypeComboBox;
    private ProgressBar passwordStrengthBar;
    private Label passwordStrengthLabel;
    private Button registerButton;
    private Button infoButton;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration Page");

        // Create form fields
        Label titleLabel = new Label("Register Account");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.setStyle("-fx-border-color: red;");
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            emailField.setStyle(newValue.trim().isEmpty() ? "-fx-border-color: red;" : "-fx-border-color: none;");
            updateRegisterButton();
        });
        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();
        firstNameField.setStyle("-fx-border-color: red;");
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            firstNameField.setStyle(newValue.trim().isEmpty() ? "-fx-border-color: red;" : "-fx-border-color: none;");
            updateRegisterButton();
        });
        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        lastNameField.setStyle("-fx-border-color: red;");
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            lastNameField.setStyle(newValue.trim().isEmpty() ? "-fx-border-color: red;" : "-fx-border-color: none;");
            updateRegisterButton();
        });
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setStyle("-fx-border-color: red;");
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            passwordField.setStyle(newValue.trim().isEmpty() ? "-fx-border-color: red;" : "-fx-border-color: none;");
            updatePasswordStrength(newValue);
            updateRegisterButton();
        });

        passwordStrengthBar = new ProgressBar();
        passwordStrengthBar.setMaxWidth(Double.MAX_VALUE);

        passwordStrengthLabel = new Label();
        passwordStrengthLabel.setWrapText(true);

        Label accountTypeLabel = new Label("Account Type:");
        accountTypeComboBox = new ComboBox<>();
        accountTypeComboBox.getItems().addAll("Job Seeker", "Recruiter");
        accountTypeComboBox.getSelectionModel().selectFirst();

        // Create registration button
        registerButton = new Button("Register");
        registerButton.setDisable(true);
        registerButton.setOnAction(e -> register());

        // Create info button
        Image infoImage = new Image("file:src/resources/info_icon.jpg");
        ImageView infoIcon = new ImageView(infoImage);
        infoIcon.setFitHeight(16);
        infoIcon.setPreserveRatio(true);
        infoButton = new Button();
        infoButton.setGraphic(infoIcon);
        infoButton.setStyle("-fx-background-color: transparent;");
        infoButton.setOnAction(e -> showTooltip());

        // Create form layout
        GridPane formLayout = new GridPane();
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.setPadding(new Insets(20));
        formLayout.add(emailLabel, 0, 0);
        formLayout.add(emailField, 1, 0);
        formLayout.add(firstNameLabel, 0, 1);
        formLayout.add(firstNameField, 1, 1);
        formLayout.add(lastNameLabel, 0, 2);
        formLayout.add(lastNameField, 1, 2);
        formLayout.add(passwordLabel, 0, 3);
        formLayout.add(passwordField, 1, 3);
        formLayout.add(infoButton, 2, 3);
        formLayout.add(passwordStrengthBar, 1, 4);
        formLayout.add(passwordStrengthLabel, 1, 5);
        formLayout.add(accountTypeLabel, 0, 6);
        formLayout.add(accountTypeComboBox, 1, 6);

        // Create root layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleLabel, formLayout, registerButton);

        // Create scene
        Scene scene = new Scene(root, 400, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void register() {
        String email = emailField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            showError("Please fill in all mandatory fields.");
            return;
        }

        // Perform registration logic here

        // Redirect to login page
        showSuccess("Registration successful. You can now log in.");
        redirectToLoginPage();
    }

    private void redirectToLoginPage() {
        // Perform the navigation to the login page
        // This is just a placeholder method
        // Replace it with your actual navigation code
        System.out.println("Navigating to login page...");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updatePasswordStrength(String password) {
        int passwordLength = password.length();
        int passwordStrength = calculatePasswordStrength(password);

        if (passwordLength < 8 || passwordStrength == 0) {
            passwordStrengthBar.setStyle("-fx-accent: red;");
            passwordStrengthBar.setProgress(0.5);
            passwordStrengthLabel.setText("Password strength: Weak");
            passwordStrengthLabel.setStyle("-fx-text-fill: red;");
            passwordField.setStyle("-fx-border-color: red;");
        } else if (passwordLength <= 10 || passwordStrength == 1) {
            passwordStrengthBar.setStyle("-fx-accent: yellow;");
            passwordStrengthBar.setProgress(0.75);
            passwordStrengthLabel.setText("Password strength: Average");
            passwordStrengthLabel.setStyle("-fx-text-fill: black;");
            passwordField.setStyle("-fx-border-color: yellow;");
        } else {
            passwordStrengthBar.setStyle("-fx-accent: green;");
            passwordStrengthBar.setProgress(1.0);
            passwordStrengthLabel.setText("Password strength: Strong");
            passwordStrengthLabel.setStyle("-fx-text-fill: green;");
            passwordField.setStyle("-fx-border-color: green;");
        }
    }

    private int calculatePasswordStrength(String password) {
        int length = password.length();
        int numCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numCount++;
            }
        }

        if (length < 10 || numCount < 2) {
            return 0; // Weak
        } else if (length <= 10 || numCount <= 3) {
            return 1; // Average
        } else {
            return 2; // Strong
        }
    }

    private void updateRegisterButton() {
        String email = emailField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String password = passwordField.getText();

        registerButton.setDisable(email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.length() < 8 || calculatePasswordStrength(password) == 0);
    }

    private void showTooltip() {
        String tooltipText = "Minimum Password Criteria:\n- 10 characters\n  including\n - 2 numeric characters";

        Tooltip tooltip = new Tooltip(tooltipText);
        tooltip.setAutoHide(true);

        // Customize tooltip style
        tooltip.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 12px;");

        double tooltipX = infoButton.getScene().getWindow().getX() + infoButton.getLayoutX() + infoButton.getWidth() - 50;
        double tooltipY = infoButton.getScene().getWindow().getY() + infoButton.getLayoutY() + infoButton.getHeight() + 50;

        tooltip.show(infoButton, tooltipX, tooltipY);
    }

}
