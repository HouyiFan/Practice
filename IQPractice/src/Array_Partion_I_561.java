import java.util.Arrays;

public class Array_Partion_I_561 {

    // In here, the java built-in sorting algorihtm is Dual-Pivot Quicksort,
    // the modified version of quicksort,
    // which takes average big theta nlogn time
    // Time: O(nlogn)
    // Space: O(1)
    public int arrayPairSum(int[] nums) {      
        int sum = 0;
        int j = 0;
        int n = nums.length / 2;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            sum += nums[j];
            j += 2;
        }
        return sum;
    }

    // Time: O(n)
    // Space: O(n)
    public int arrayPairSum2(int[] nums) {
        
        int[] exist = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            exist[nums[i] + 10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < exist.length; i++) {
            while (exist[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                exist[i]--;
            }
        }
        return sum;
    }
}
