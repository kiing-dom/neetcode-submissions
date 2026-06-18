class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        int[] sFreq = new int[128];
        int[] tFreq = new int[128];
        int required = 0;
        int formed = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        for (int f : tFreq) {
            if (f > 0) {
                required++;
            }
        }

        int left = 0;
        String minWindowSubstring = "";
        for (int right = 0; right < s.length(); right++) {
            sFreq[s.charAt(right)]++;

            if (sFreq[s.charAt(right)] == tFreq[s.charAt(right)]) {
                formed++;
            }

            while (formed == required) {
                int windowSize = right - left + 1;
                if (windowSize < bestLen) {
                    bestStart = left;
                    bestLen = windowSize;
                }
                sFreq[s.charAt(left)]--;
                if (sFreq[s.charAt(left)] < tFreq[s.charAt(left)]) {
                    formed--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);              
    }
}