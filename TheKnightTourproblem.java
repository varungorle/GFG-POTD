import java.util.*;

class Solution 
{
    private static final int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
    private int n;
    private int[][] board;

    public ArrayList<ArrayList<Integer>> knightTour(int n) 
    {
        this.n = n;
        board = new int[n][n];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], -1);
        
        board[0][0] = 0;

        if (solve(0, 0, 1)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) 
            {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    row.add(board[i][j]);
                result.add(row);
            }
            return result;
        } 
        else 
        {
            return new ArrayList<>(); 
        }
    }

    private boolean solve(int x, int y, int moveCount) 
    {
        if (moveCount == n * n)
            return true;

        for (int i = 0; i < 8; i++) 
        {
            int nextX = x + rowMove[i];
            int nextY = y + colMove[i];
            if (isValid(nextX, nextY)) 
            {
                board[nextX][nextY] = moveCount;
                if (solve(nextX, nextY, moveCount + 1))
                    return true;
                board[nextX][nextY] = -1; 
            }
        }
        return false;
    }

    private boolean isValid(int x, int y)
    {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
}

public class TheKnightTourproblem 
{
    public static void main(String[] args) 
    {
        Solution obj = new Solution();
        ArrayList<ArrayList<Integer>> ans = obj.knightTour(5);
        if (ans.isEmpty()) 
            System.out.println("false");
        else 
        {
            System.out.println("true");
            for (ArrayList<Integer> row : ans)
                System.out.println(row);
        }
    }
}
