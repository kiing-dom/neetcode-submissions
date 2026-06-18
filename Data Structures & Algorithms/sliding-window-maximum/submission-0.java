class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        Deque<Integer> dq = new ArrayDeque<>();
        int left = 0;
        int[] res = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums [right]) {
                dq.pollLast();
            }

            dq.offerLast(right);

            if (dq.peekFirst() < right - k + 1) {
                dq.pollFirst();
            }

            if (right >= k - 1) {
                res[left++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}