class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int len = s1.length();
        for (int right = 0; right < s2.length(); right++) {
            s2Map.put(s2.charAt(right), s2Map.getOrDefault(s2.charAt(right), 0) + 1);

            while (right - left + 1 > len) {
                s2Map.put(s2.charAt(left), s2Map.get(s2.charAt(left)) - 1);
                if (s2Map.get(s2.charAt(left)) == 0) s2Map.remove(s2.charAt(left));
                left++;
            }

            if (s1Map.equals(s2Map)) return true;
        }

        return false;
    }
}