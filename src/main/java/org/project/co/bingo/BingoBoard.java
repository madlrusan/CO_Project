package org.project.co.bingo;

import java.math.BigInteger;
import java.util.Random;
import static org.project.co.BigPi.spigot.myspigot;

public class BingoBoard
{
    public static int[][] board;

    public BingoBoard()
    {
        board = new int[5][5];
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                board[i][j] = 0;
            }
        }
    }

    public static void createBoard()
    {
        int i, j;
        for(j=0; j<5; j++)
        {
            for(i=0; i<5; i++)
            {
                board[i][j]= chooseRandomNumber(i, j, (j+1)*15+1);
            }
        }
    }

    public static int chooseRandomNumber(int i, int j, int max)
    {
        Random random = new Random();
        int rand = random.nextInt(max);
        BigInteger no = myspigot(rand*100);
        BigInteger n = no.remainder(BigInteger.valueOf(max));
        if(checkNumber(i, j, n.intValue()))
            return n.intValue();
        else
            return chooseRandomNumber(i,j,max);
    }

    public static boolean checkNumber(int x, int y, int number)
    {
        for(int i=(x-1); i>=0; i--)
        {
            if(board[i][y] == number)
                return false;
        }
        if((number <= (y+1)*15) && number >= (y*15+1))
            return true;
        return false;
    }
}
