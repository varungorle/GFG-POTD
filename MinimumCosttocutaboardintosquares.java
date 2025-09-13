public class MinimumCosttocutaboardintosquares 
{
    public static int minCost(int n, int m, int[] x, int[] y) 
    {
        sortDescending(x);
        sortDescending(y);
        
        int i = 0, j = 0;
        int horizontalSegments = 1;
        int verticalSegments = 1;
        int totalCost = 0;
        
        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                totalCost += x[i] * horizontalSegments;
                verticalSegments++;
                i++;
            } else {
                totalCost += y[j] * verticalSegments;
                horizontalSegments++;
                j++;
            }
        }
        
        while (i < x.length) {
            totalCost += x[i] * horizontalSegments;
            verticalSegments++;
            i++;
        }
        
        while (j < y.length) {
            totalCost += y[j] * verticalSegments;
            horizontalSegments++;
            j++;
        }
        
        return totalCost;
    }
    
    private static void sortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, m = 6;
        int[] x = {2, 1, 3, 1, 4};
        int[] y = {4, 1, 2};
        
        System.out.println(minCost(n, m, x, y));
    }
}
