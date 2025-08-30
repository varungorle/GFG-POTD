public class TheCelebrityProblem 
{
    public static void main(String[] args)
    {
        Solution sol=new Solution();
        int[][] mat={
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };
        int celebrity=sol.celebrity(mat);
        if(celebrity==-1)
        {
            System.out.println("no celebrity found");
        }
        else
        {
            System.out.println("celebrity is person:"+celebrity);
        }
    }
}
class Solution 
{
    public int celebrity(int[][] mat) 
    {
        int n = mat.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[i][j] == 1) 
            {
                i++; 
            } 
            else 
            {
                j--; 
            }
        }
        int candidate = i;
        for (int k = 0; k < n; k++) 
        {
            if (k != candidate) 
            {
                if (mat[candidate][k] == 1 || mat[k][candidate] == 0) 
                {
                    return -1;
                }
            }
        }

        return candidate;
    }
}

