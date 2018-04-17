
public class Remove_Duplicates_from_Sorted_Array_26 {

    // Two pointers
    // Time: O(n)
    // Space: O(1)
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int insertPos = 0;
        int e = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != e) {
                nums[insertPos++] = e;
                e = nums[i];
            }
        }
        nums[insertPos++] = e; //add the last element
        return insertPos;
    }

    // One pass
    // Time: O(n)
    // Space: O(1)
    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 3, 3 };

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeDuplicates1(nums);
        System.out.println(len);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
