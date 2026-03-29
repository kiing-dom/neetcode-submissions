class Solution {
    public boolean hasDuplicate(int[] nums) {
       if (nums == null || nums.length == 0) {
            return false;
       }

       Set<Integer> seen = new HashSet<>();
       for (int num : nums) {
            if (seen.contains(num)) return  true;

            seen.add(num);
       }

    return false;
    }
}