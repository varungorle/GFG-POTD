public class Smallestwindowcontainingallcharacters {
    public static String smallestWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            need[c]++;
        }

        int required = p.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                if (window[c] < need[c]) {
                    required--;
                }
            }
            window[c]++;
            right++;

            // Try to shrink window
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                if (need[d] > 0) {
                    if (window[d] <= need[d]) {
                        required++;
                    }
                }
                window[d]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    // ✅ Correct main method
    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";
        System.out.println(smallestWindow(s, p)); // Output: toprac
    }
}
