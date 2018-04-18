import java.util.Arrays;

public class Move_Zeroes_283 {

    // Swap the front element whenever we find a non-zero element
    // Time: O(n)
    // Space: O(1)
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0; //the index that nonzero should be put if we find it
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //  swap is necessary since if the first element is 1,
                //  if you let nums[i] = 0 then 1 will be replaced by 0
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    // No swap operation1 --but it has more operation than the first one,
    // e.g.when nums = {0, 0, 0, ... , 0, 1}, while loop will execute (n - 1) times
    // Time: O(n)
    // Space: O(1)
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // No swap operation2
    // Time: O(n)
    // Space: O(1)
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int num0 = 0; //number of zero
        int pos0 = 0; //pos of first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (num0 == 0) {
                    pos0 = i;
                }
                num0++;
            } else if (num0 > 0) { //if nums[i] != 0 and num0 > 0
                nums[pos0] = nums[i];
                nums[i] = 0;
                pos0++;
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[] { 1 };
        moveZeroes1(a);
        System.out.println(Arrays.toString(a));

    }

}
