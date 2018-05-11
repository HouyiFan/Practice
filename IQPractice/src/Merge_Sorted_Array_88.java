import java.util.Arrays;

public class Merge_Sorted_Array_88 {

    // Time: O(m + n)
    // Space: O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int n = 3;
        int[] nums2 = new int[] { 2, 5, 6 };
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1)); //[1, 2, 2, 3, 5, 6]
    }

}
