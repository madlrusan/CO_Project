public class IfWin {
    //public static int[][] cardArray2D = { {-1,2,3,4,5}, {12,-1,14,15,19}, {11,12,4,76,46}, {31,32,33,-1,35}, {41,42,43,44,-1}};
	public static int[][] cardArray2D = { {1,2,3,-1,5}, {12,51,14,-1,19}, {11,12,4,-1,46}, {31,32,33,-1,35}, {41,42,43,-1,46}};
    //public static int[][] cardArray2D = { {-1,2,3,4,5}, {12,-1,14,15,19}, {11,12,-1,76,46}, {31,32,33,-1,35}, {41,42,43,44,-1}};
    //public static int[][] cardArray2D = { {1,2,3,4,5}, {12,13,14,15,19}, {-1,-1,-1,-1,-1}, {31,32,33,34,35}, {41,42,43,44,45}};
    public static boolean HORIZONTALBINGO = false;
    public static boolean VERTICALBINGO = false;
    public static boolean DIAGONALBINGO = false;

    public static boolean checkForWin(int[][] board)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int horizontalSum = 0;
        int verticalSum = 0;
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;


        while ( (horizontalSum != -5) && (i < 5))
        {
            horizontalSum=0;
            horizontalSum = checkHorizontalSum(i, board);
            i++;
        }
        //Horizontal bingo check
        if (horizontalSum ==-5)
        {
            HORIZONTALBINGO = true;
        }
        while ((verticalSum != -5) && (j < 5))

        {
            verticalSum=0;
            verticalSum = checkVerticalSum(j, board);
            j++;
        }
        if (verticalSum == -5)
        {
            VERTICALBINGO = true;
        }

        for (i = 0; i < 5; i++)
        {
            diagonalSum1 += board[i][i];
        }

        for  (i = 0; i < 5; i++)
        {
            diagonalSum2 += board[i][5-i-1];
        }

        if ((diagonalSum1 == -5) || (diagonalSum2 == -5))
        {
            DIAGONALBINGO = true;
        }

        if ((HORIZONTALBINGO == true) || (VERTICALBINGO == true) || (DIAGONALBINGO == true))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int checkHorizontalSum(int i, int[][] board)
    {
        int sum = 0;

        for (int j = 0; j < 5; j++)
        {
            sum += board[i][j];
        }

        return sum;
    }


    public static int checkVerticalSum(int j, int[][] board)
    {
        int sum = 0;

        for (int i = 0; i < 5; i++)
        {
            sum += board[i][j];
        }
        return sum;
    }
    public static void main(String[] args) {

      	int[][] board = { {-1,2,3,4,5}, {12,-1,14,15,19}, {11,12,4,76,46}, {31,32,33,-1,35}, {41,42,43,44,-1}};
		checkForWin(board);

        int j = 0;
        if (HORIZONTALBINGO == true)
        {
            System.out.println("horizontal win");
        }
        else if (VERTICALBINGO == true)
        {
            System.out.println("vertical win");
        }
        else if (DIAGONALBINGO == true)
        {
            System.out.println("diagonal win");
        }

    }
}
