
public class Remove_Element_27 {

    // Two pointers
    // Time: O(n)
    // Assume the array has a total of n elements, both i and insertPos
    // traverse at most 2n steps.(when val is not in nums)
    // Space: O(1)
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertPos++] = nums[i];
            }
        }
        return insertPos;
    }

    // Two pointers (more efficient if elements to remove are rare)
    // Time: O(n)
    // Both i and n traverse at most n steps. In this approach,
    // the number of assignment operation is equal to the number of
    // elements to remove. So it is more efficient if elements to
    // remove are rare.
    // Space: O(1)
    public static int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 2, 3 };
        int val = 3;

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement1(nums, val);
        System.out.println(len);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
