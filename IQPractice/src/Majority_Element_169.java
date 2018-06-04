import java.util.HashMap;
import java.util.Map;

public class Majority_Element_169 {
    // HashMap
    // Time: O(n)
    // Space: O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                return res;
            }
        }
        return res;
    }

    // Divide and Conquer
    // Time: O(nlogn), T(n) = 2T(n / 2) + 2n
    // Space: O(logn)
    public int majorityElement1(int[] nums) {
        return this.subMajor(nums, 0, nums.length - 1);
    }

    private int subMajor(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right - left) / 2 + left;
        int leftSubMajor = this.subMajor(nums, left, mid);
        int rightSubMajor = this.subMajor(nums, mid + 1, right);

        if (leftSubMajor == rightSubMajor) {
            return leftSubMajor;
        }

        int leftCount = this.count(nums, leftSubMajor, left, right);
        int rightCount = this.count(nums, rightSubMajor, left, right);

        return leftCount >= rightCount ? leftSubMajor : rightSubMajor;
    }

    private int count(int[] nums, int val, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        return count;

    }
}
