
public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

    // Follow-up of #153: when nums may contain duplicates
    // 这两题我都是比较左边和中间，但是貌似比较右边和中间的方法会更简单
    // Time: O(logn), in the worst case, it it O(n), e.g. nums = {1, 1, 1}
    // Space: O(1)
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[low]) { //min is after mid
                if (nums[low] > nums[high]) {
                    low = mid + 1;
                } else if (nums[low] < nums[high]) { //min is before mid
                    high = mid;
                } else {
                    low++;
                }
            } else if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                low++;
            }
        }
        return Math.min(nums[low], nums[high]);
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 1, 3, 5 };
        System.out.println(findMin(test1)); // 1

        int[] test2 = new int[] { 2, 2, 2, 0, 1 };
        System.out.println(findMin(test2)); // 0

        int[] test3 = new int[] { 1, 2, 1 };
        System.out.println(findMin(test3)); // 1

        int[] test4 = new int[] { 1, 2, 2, 2, 0, 1, 1 };
        System.out.println(findMin(test4)); // 0

    }

}
