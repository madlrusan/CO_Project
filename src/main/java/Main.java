import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.project.co.bingo.BingoBoard;

import static org.project.co.bingo.BingoBoard.createBoard;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BingoBoard b = new BingoBoard();
        createBoard();

        Label label1 = new Label("Board created!");
        VBox layout = new VBox(25);
        layout.getChildren().add(label1);
        Scene scene = new Scene(layout,300,250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}