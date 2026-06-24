class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) return 0;

        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int k = left + (right - left) / 2;

            if (isFeasible(piles, h, k)) {
                right = k;
            } else {
                left = k + 1;
            }
        }

        return left;
    }

    private boolean isFeasible(int[] piles, int h, int k) {
        int totalTime = 0;
        for (int p : piles) {
            totalTime += (p + k - 1) / k;
            if (totalTime > h) return false;
        }

        return totalTime <= h;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}