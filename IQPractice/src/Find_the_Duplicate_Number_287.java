
public class Find_the_Duplicate_Number_287 {

    // 题目要求不能改变数组本身，space complexity必须为O(1)，time complexity should
    // be less than O(n^2), 数组中只有一个重复元素
    // Time: O(nlogn)
    // Space: O(1)
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //nums有n＋1个数，所以high应为length-1，从而构成区间[1, n]
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2; // avoid overflow
            int count = 0;
            for (int a : nums) {
                if (a <= mid) {
                    count++;
                }
            }
            //计算[1, n]中小于等于mid的数的个数，如果个数大于mid，说明重复元素在[1, mid]中，
            //反之则在[mid + 1, n]
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(test1)); //2
        int[] test2 = new int[] { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(test2)); //3
    }

}
