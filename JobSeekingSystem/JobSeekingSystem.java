package JobSeekingSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JobSeekingSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Job Seeking System");

        // Create labels and buttons
        Label titleLabel = new Label("Job Seeking System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Button registerButton = new Button("Register");
        Button loginButton = new Button("Login");

        // Set button actions
        registerButton.setOnAction(e -> {
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.start(primaryStage);
        });

        loginButton.setOnAction(e -> {
            login login = new login();
            login.start(primaryStage);
        });

        // Create layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, registerButton, loginButton);

        // Create scene
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
