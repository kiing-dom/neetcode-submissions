class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int pre = 1;
        int suf = 1;

        int[] aux = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            aux[i] = pre;
            pre *= nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            aux[i] *= suf;
            suf *= nums[i];
        }

        return aux;
    }
}


/**
    nums = [1, 2, 4, 6]
          1            1
    aux = [1, 1, 2, 8]

    res = [48, 24, 12, 8]
*/
