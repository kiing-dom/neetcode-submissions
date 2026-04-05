class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       if (nums == null || nums.length == 0) return Collections.emptyList();

       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);
       for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tripletSum = nums[i] + nums[left] + nums[right];

                if (tripletSum < 0) {
                    left++;
                } else if (tripletSum > 0) {
                    right--;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
       }

       return result;
    }
}
