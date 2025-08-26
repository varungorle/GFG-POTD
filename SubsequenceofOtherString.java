class Solution 
{
    public boolean isSubSeq(String s1, String s2) 
    {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) 
        {
            if (s1.charAt(i) == s2.charAt(j)) 
            {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
public class SubsequenceofOtherString 
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s1 = "AXY";
        String s2 = "YADXCP";

        if (sol.isSubSeq(s1, s2)) 
        {
            System.out.println(s1 + " is a subsequence of " + s2);
        } 
        else 
        {
            System.out.println(s1 + " is NOT a subsequence of " + s2);
        }
    }
}