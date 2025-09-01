import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SumofMode 
{
    class Solution 
    {
        private Map<Integer, Integer> freq;              
        private Map<Integer, TreeSet<Integer>> countMap; 
        private int maxFreq;

        public int sumOfModes(int[] arr, int k) 
        {
            int n = arr.length;
            freq = new HashMap<>();
            countMap = new HashMap<>();
            maxFreq = 0;
            int result = 0;

            // First window
            for (int i = 0; i < k; i++) 
            {
                update(arr[i], +1);
            }
            result += countMap.get(maxFreq).first();

            // Sliding window
            for (int i = k; i < n; i++) 
            {
                update(arr[i - k], -1); 
                update(arr[i], +1);     
                result += countMap.get(maxFreq).first();
            }

            return result;
        }

        private void update(int num, int delta) 
        {
            int oldFreq = freq.getOrDefault(num, 0);
            int newFreq = oldFreq + delta;

            // Remove from old frequency
            if (oldFreq > 0) 
            {
                countMap.get(oldFreq).remove(num);
                if (countMap.get(oldFreq).isEmpty()) 
                {
                    countMap.remove(oldFreq);
                    if (maxFreq == oldFreq) maxFreq--;
                }
            }

            // Add to new frequency
            if (newFreq > 0) 
            {
                freq.put(num, newFreq);
                countMap.putIfAbsent(newFreq, new TreeSet<>());
                countMap.get(newFreq).add(num);
                if (newFreq > maxFreq) maxFreq = newFreq;
            } 
            else 
            {
                freq.remove(num);
            }
        }
    }

    public static void main(String[] args) 
    {
        SumofMode outer = new SumofMode();
        SumofMode.Solution sol = outer.new Solution();

        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        int k = 3;

        int result = sol.sumOfModes(arr, k);
        System.out.println("Sum of modes for subarrays of length " + k + " = " + result);
    }
}
