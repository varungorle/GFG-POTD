public class Largestnumberinoneswap 
{
    public String largestString(String s) 
    {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] last = new int[10];
        for (int i = 0; i < n; i++) 
        {
            last[arr[i] - '0'] = i;
        }
        for (int i = 0; i < n; i++) 
        {
            int current = arr[i] - '0';
            for (int d = 9; d > current; d--) 
            {
                if (last[d] > i) 
                {
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;
                    return new String(arr);
                }
            }
        }
        return s; 
    }
    public static void main(String[] args) 
    {
        Largestnumberinoneswap obj = new Largestnumberinoneswap();
        System.out.println(obj.largestString("768"));   
    }
}

