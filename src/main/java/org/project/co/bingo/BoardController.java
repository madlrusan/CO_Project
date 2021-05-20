package org.project.co.bingo;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static org.project.co.bingo.BingoBoard.board;

public class BoardController
{
    public static void handleNumberAction(int i, int j)
    {
        board[i][j] = -1;
    }
}
