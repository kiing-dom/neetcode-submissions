class Solution {
    public int maxArea(int[] heights) {
       if (heights == null || heights.length == 0) {
            return 0;
        }

       int left = 0;
       int right = heights.length - 1;
        
        int maxArea = 0;
        while (left < right) {
           int length = right - left;

           int area = Math.min(heights[left], heights[right]) * length;
           maxArea = Math.max(maxArea, area);

           if (heights[left] < heights[right]) {
            left++;
           } else if (heights[left] > heights[right]) {
            right--;
           } else {
            left++;
           }
        }

        return maxArea;
    }
}
