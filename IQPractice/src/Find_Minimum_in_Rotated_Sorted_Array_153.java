
public class Find_Minimum_in_Rotated_Sorted_Array_153 {

    // Time: O(logn)
    // Space: O(1)
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //min must be in the sorted part
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[low]) {
                //min is after mid
                if (nums[low] > nums[high]) {
                    low = mid + 1;
                } else { //min is before mid
                    high = mid;
                }
            } else if (nums[mid] < nums[low]) {
                high = mid;
            }
        }
        return Math.min(nums[low], nums[high]);
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(findMin(test1)); // 1
        int[] test2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(test2)); // 0
    }

}
