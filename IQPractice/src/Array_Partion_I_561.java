import java.util.Arrays;

public class Array_Partion_I_561 {

    public int arrayPairSum(int[] nums) {
        //In here, the java built-in sorting algorihtm is Dual-Pivot Quicksort,
        //the modified version of quicksort,
        //which takes average big theta nlogn time
        //O(nlogn) solution
        //O(1) space
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

    public int arrayPairSum2(int[] nums) {
        //O(n) solution, really smart
        //Defect: O(n) space
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

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
