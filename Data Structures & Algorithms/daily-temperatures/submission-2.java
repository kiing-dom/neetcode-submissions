class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                int colderIdx = stack.pollFirst();
                int wait = i - colderIdx;
                res[colderIdx] = wait;
            }
            stack.offerFirst(i);
        }

        return res;
    }
}