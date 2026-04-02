class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       if (nums.length == 1) return 1;

       Set<Integer> seen = new HashSet<>();
       for (int num : nums) {
        seen.add(num);
       }

       int longestConsecutive = 0;
       for (int num : nums) {
        if (!seen.contains(num - 1)) {
            int curr = num;
            int currLongest = 1;

            while (seen.contains(curr + 1)) {
                curr++;
                currLongest++;
            }

            longestConsecutive = Math.max(longestConsecutive, currLongest);
        }
       }

       return longestConsecutive;
    }
}
