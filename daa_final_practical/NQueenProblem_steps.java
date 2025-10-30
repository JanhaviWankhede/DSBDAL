package daa_final_practical;

public class NQueenProblem_steps {
    final int N = 4;
    static int step = 1;

    void printBoard(int board[][]) {
        System.out.println("Step " + step++ + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                System.out.println("Placing queen at (" + i + "," + col + ")");
                printBoard(board);

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
                System.out.println("Backtracking from (" + i + "," + col + ")");
                printBoard(board);
            }
        }
        return false;
    }

    boolean solveNQ() {
        int board[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        System.out.println("Final Solution:");
        printBoard(board);
        return true;
    }

    public static void main(String args[]) {
        NQueenProblem_steps Queen = new NQueenProblem_steps();
        Queen.solveNQ();
    }
}

