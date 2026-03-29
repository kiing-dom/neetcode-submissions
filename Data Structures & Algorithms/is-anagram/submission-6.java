class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] freq = new int[26];

        for (char c : sChars) {
            freq[c - 'a']++;
        }

        for (char c : tChars) {
            freq[c - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }

        return true;
    }
}
