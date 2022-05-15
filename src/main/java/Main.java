import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
* alt enter on Application and import the javafx one
* alt enter Main line and implement methods keeping default options
* alt enter @Override and select add modules option
*
* have to alt enter to fix a lot
* always choose to import the javafx one if given an option
*/

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        primaryStage.setTitle("Color Shuffle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); // this always comes at the end of this method
    }
}
