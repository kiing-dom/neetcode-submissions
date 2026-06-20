class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0 || speed == null || speed.length == 0) {
            return 0;
        }

        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Deque<Double> stack = new ArrayDeque<>();

        for (int[] car : cars) {
            int pos = car[0];
            int spe = car[1];
            double time = (double) (target - pos) / spe;

            if (stack.isEmpty() || time > stack.peekFirst()) {
                stack.offerFirst(time);
            } 
        }

        return stack.size();
    }
}

/**
    given:
    - position: int[]
    - speed: int[]
    (both arrays length n)
    - target: int

    return:
    - the number of car fleets that will arrive at the destination (n)
*/