package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    window=primaryStage;
    window.setTitle("test");
        TextField nameInput = new TextField();
        button = new Button("click me");
        button.setOnAction(e->isint(nameInput,nameInput.getText()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput,button);

        scene = new Scene(layout, 300 ,250);
        window.setScene(scene);
        window.show();


}

private boolean isint(TextField input ,String message)
{
    try {
        int age = Integer.parseInt(message);
        System.out.println("User is:"+age);
        return true;
    } catch(NumberFormatException e){
        System.out.println("Enter a valid number");
    return false;
    }
}
}