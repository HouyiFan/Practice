import java.util.Arrays;

public class Rotate_Array_189 {

    // Time: O(n)
    // Space: O(1)
    public void rotate(int[] nums, int k) {
        if (k > 0) {
            int n = nums.length;
            int shift = k % nums.length;
            swap(nums, 0, n - 1);
            swap(nums, 0, shift - 1);
            swap(nums, shift, n - 1);
        }

    }

    public static void swap(int[] nums, int start, int end) {
        while (start + 1 <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // Time: O(n)
    // Space: O(n)
    public void rotate2(int[] nums, int k) {
        if (k > 0) {
            int n = nums.length;
            int shift = k % nums.length;
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[(i + shift) % n] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                nums[i] = a[i];
            }
        }

    }

    // Time: O(n)
    // Space: O(1)
    public static void rotate3(int[] nums, int k) {
        if (k > 0) {
            int n = nums.length;
            int count = 0;
            k = k % n;
            for (int i = 0; count < n; i++) {
                int cur = i;
                int prev = nums[i];
                do {
                    int next = (cur + k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    cur = next;
                    count++;
                } while (i != cur);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate3(num, 3);
        System.out.println(Arrays.toString(num));

    }

}
