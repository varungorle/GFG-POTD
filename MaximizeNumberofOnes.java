class Solution 
{
    public int maxOnes(int arr[], int k) 
    {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) 
        {
            if (arr[right] == 0) 
            {
                zeroCount++;
            }
            while (zeroCount > k) 
            {
                if (arr[left] == 0) 
                {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
public class MaximizeNumberofOnes 
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int arr[]={1,0,1,1,0,0,1,1,1};
        int k=2;
        int result=sol.maxOnes(arr, k);
        System.out.println("maximum consecutive numbers after fliping:" + k +" zeros = "+result);
    }
}
