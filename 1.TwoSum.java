/**
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
  * 思路就是通过目标值减去某个值，然后查询数组内有没有其差值
  */

// O(n²)
public int[] twoSum(int[] nums, int target) {
    int[] ret = {};
    int m = 0, n = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        int b = target - nums[i];
        m = i;
        for (int j = i + 1; j < nums.length; j++) {
            n = j;
            if (nums[j] == b) {
                int ret2[] = {m, n};
                return ret2;
            }
        }
    }
    return ret;
}

// O(n)
public int[] twoSum(int[] nums, int target) {
    int[] ret = {};
    int m = 0, n = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        int b = target - nums[i];
        m = i;
        for (int j = i + 1; j < nums.length; j++) {
            n = j;
            if (nums[j] == b) {
                int ret2[] = {m, n};
                return ret2;
            }
        }
    }
    return ret;
}