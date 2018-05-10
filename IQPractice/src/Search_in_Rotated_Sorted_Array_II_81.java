
public class Search_in_Rotated_Sorted_Array_II_81 {

    // Time: O(logn), in worst case: O(n)
    // Space: O(1)
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else if (nums[mid] < nums[low]) {
                if (target <= nums[high] && target >= nums[mid]) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else { //nums[mid] == nums[low], two cases: 1)all elements between them are the same, 2)elements between them are different
                low++; //in the worst case, we need to increase the low pointer by 1 at each time, so it will be O(n)
            }
        }
        if (nums[low] == target) {
            return true;
        }
        if (nums[high] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // true
        System.out.println(search(new int[] { 3, 3, 3, 3, 1, 3, 3 }, 1)); // true
        System.out.println(search(new int[] { 3, 3, 3, 3, 1, 3, 3 }, 2)); // true
    }

}
