package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-22 10:41
 */
public class S33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // mid位置 有两种可能
            // 位于前半段 位于后半段
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                //左侧是有序的 如果相等 说明是一个数
                if (target >= nums[left] && target <= nums[mid]) {
                    // 左侧找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 左侧不确定是不是有序的 右侧一定是有序的
                if (target >= nums[mid] && target <= nums[right]) {
                    // 在右侧
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        S33 s33 = new S33();
        int index = s33.search(new int[]{3,1}, 1);
        System.out.println(index);
    }
}
