import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.project.co.RandomGen.bingoNumbers;
import org.project.co.Timing.Timer;
import org.project.co.bingo.BingoBoard;

import java.util.concurrent.atomic.AtomicInteger;

import static org.project.co.bingo.BingoBoard.board;
import static org.project.co.bingo.BingoBoard.createBoard;
import static org.project.co.bingo.BoardController.handleNumberAction;

public class Main extends Application
{
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BingoBoard b = new BingoBoard();
        Timer timer = new Timer();
        timer.start();
        createBoard();
        int[] numbers = bingoNumbers.generateBingo();
        timer.stop();

        BorderPane pane = new BorderPane();
        GridPane brd = new GridPane();

        //the board
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                Button btn = new Button();
                btn.setText(String.valueOf(board[i][j]));
                btn.setPrefHeight(60);
                btn.setPrefWidth(60);
                btn.setAlignment(Pos.CENTER);
                btn.setStyle("-fx-background-color: white; -fx-background-radius: 0; -fx-border-color: black");
                int finalI = i;
                int finalJ = j;
                btn.setOnAction((ActionEvent e) -> {
                    btn.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 0");
                    handleNumberAction(finalI, finalJ);
                });

                GridPane.setRowIndex(btn, i);
                GridPane.setColumnIndex(btn, j);
                brd.getChildren().add(btn);
            }
        }
        brd.setAlignment(Pos.CENTER);

        //the random number generator
        Label no = new Label("Press get number when ready to play");
        no.setStyle("-fx-font-size: 25px");
        Button btn2 = new Button();
        btn2.setText("Get number");
        AtomicInteger i = new AtomicInteger(0);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(i.intValue()<50) {
                    i.getAndIncrement();
                    no.setText(String.valueOf(numbers[i.intValue()]));
                }
                else
                {
                    VBox lose = new VBox();
                    Label message = new Label("You lost! Try again!");
                    message.setAlignment(Pos.CENTER);
                    message.setStyle("-fx-font-size: 40px");
                    lose.getChildren().add(message);
                    lose.setAlignment(Pos.CENTER);

                    Scene loseScene = new Scene(lose, 600, 500);
                    primaryStage.setScene(loseScene);
                }
            }
        });

        //setting the border pane
        VBox top = new VBox(10);
        top.getChildren().addAll(no, btn2);
        top.setAlignment(Pos.CENTER);

        Label lbl1 = new Label("Time spent creating the board and generating numbers using Spigot's algorithm: ");
        Label lbl2 = new Label(String.valueOf((double)timer.checkTime()/1000000000));
        HBox bottom = new HBox(10);
        bottom.getChildren().addAll(lbl1, lbl2);
        bottom.setAlignment(Pos.CENTER);

        pane.setTop(top);
        pane.setCenter(brd);
        pane.setBottom(bottom);

        Scene scene = new Scene(pane,600,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}