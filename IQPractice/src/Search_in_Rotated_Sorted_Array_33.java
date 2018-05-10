
public class Search_in_Rotated_Sorted_Array_33 {

    // Time: O(logn)
    // Space: O(1)
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        //分多钟情况：mid,target是在sorted还是rotated part
        while (low + 1 < high) {
            int mid = low + (high - low) / 2; //avoid overflow
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) { //target in rotated part
                    high = mid;
                } else { //target in sorted part
                    low = mid;
                }
            } else {
                if (target <= nums[high] && target >= nums[mid]) { //target in sorted part
                    low = mid;
                } else { //target in rotated part
                    high = mid;
                }
            }
        }
        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)); // -1

    }

}
