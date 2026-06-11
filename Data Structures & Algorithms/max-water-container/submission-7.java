class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;

        int maxA = 0;
        while (left < right) {
            int L = right - left;
            int H = Math.min(height[right], height[left]);

            int A = L * H;

            maxA = Math.max(maxA, A);

            if (height[right] < height[left]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxA;
    }
}