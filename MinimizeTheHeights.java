class Solution 
{
    public int getMinDiff(int[] arr, int k) 
    {
        int n = arr.length;
        if (n == 1) return 0;

        mergeSort(arr, 0, n - 1);

        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) 
        {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);

            if (min < 0) continue;

            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    private void mergeSort(int[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) 
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}

public class MinimizeTheHeights 
{
    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        
        int[] arr = {1, 5, 8, 10};
        int k = 2;

        int result = sol.getMinDiff(arr, k);
        System.out.println("Minimum difference is: " + result);
    }
}
