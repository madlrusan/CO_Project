import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.project.co.bingo.BingoBoard;

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
        createBoard();

        GridPane brd = new GridPane();

        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                Button btn = new Button();
                btn.setText(String.valueOf(board[i][j]));
                btn.setPrefHeight(60);
                btn.setPrefWidth(60);
                btn.setAlignment(Pos.CENTER);
                btn.setStyle("-fx-background-color: beige; -fx-background-radius: 0; -fx-border-color: black");
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

        Button btn2 = new Button();
        btn2.setText("press here");
        GridPane.setColumnIndex(btn2,6);
        GridPane.setRowIndex(btn2, 8);
        btn2.setOnAction((ActionEvent e) -> {
            for(int i=0;i<5;i++) {
                for (int j = 0; j < 5; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        });

        brd.getChildren().add(btn2);
        Scene scene = new Scene(brd,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}