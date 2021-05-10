import java.util.HashMap;

class ifWin{
    private boolean win;

    private final int BOARD_DIM = 5;
    eventCalledMap = new HashMap<>();
                eventCalledMap.put(FREE, true);


    public boolean checkWin()
    {
        this.win = evalBoard();
        return this.win;
    }

    private boolean evalBoard()
    {
        int i, j, count;

        for(i = 0; i<BOARD_DIM; i++)
        {
            j = 0;
            count = 0;
            while(eventCalledMap.get(board[i][j]) != false)
            {
                count++;
                j++;
                if(count == BOARD_DIM)
                    return true;
            }

            j = 0;
            count = 0;
            while(eventCalledMap.get(board[j][i]) != false)
            {
                count++;
                j++;
                if(count == BOARD_DIM)
                    return true;
            }
        }

        i = 0;
        count = 0;

        while(eventCalledMap.get(board[i][i]) != false)
        {
            count++;
            i++;
            if(count == BOARD_DIM)
                return true;
        }

        i = BOARD_DIM -1;
        j = 0;
        count = 0;

        while(eventCalledMap.get(board[i][j]) != false)
        {
            count++;
            i--;
            j++;
            if(count == BOARD_DIM)
                return true;
        }
        return false;
    }


}