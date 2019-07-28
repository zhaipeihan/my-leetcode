package cc.peihan.java.all.leetcode;

public class T215 {

    public int findKthLargest(int[] nums, int k) {
        return quick_select(nums, nums.length - k, 0, nums.length - 1);
    }


    private int quick_select(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int base = patition(nums, start, end);
        if (base == k) {
            return nums[base];
        } else if (base < k) {
            return quick_select(nums, k, base + 1, end);
        } else {
            return quick_select(nums, k, start, base - 1);
        }
    }

    private int patition(int[] nums, int start, int end) {
        int p = nums[start];
        while (start < end) {
            while (nums[end] >= p && start < end) {
                end--;
            }
            nums[start] = nums[end];
            while (nums[start] <= p && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = p;
        return start;
    }


}
