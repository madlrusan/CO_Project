import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Index extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("index.fxml"));
        } catch (IOException e) {
            System.out.println("in catch");
            e.printStackTrace();
            System.exit(0);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
