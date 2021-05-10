package org.project.co.bingo;

import static org.project.co.bingo.BingoBoard.board;

public class BoardController
{
    public static void handleNumberAction(int i, int j)
    {
        board[i][j] = -1;
    }
}
