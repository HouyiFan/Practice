
public class Maximum_Subarray_53 {

    // DP Solution
    // Time: O(n)
    // Space: O(n)
    public static int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int len = A.length;
        int[] dp = new int[len]; // dp[i] means the maximum subarray ending with A[i]
        dp[0] = A[0];
        for (int i = 1; i < len; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Without DP solution
    // Time: O(n)
    // Space: O(1)
    public static int maxSubArray1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int sum = A[0];
        int max = A[0];
        int len = A.length;

        for (int i = 1; i < len; i++) {
            if (sum < 0) {
                sum = A[i];
            } else {
                sum += A[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    // Divide and Conquer
    // Time: O(nlogn), T(n) = 2T(n/2) + O(n)
    // Space: O(1)
    public static int maxSubArray2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        return maxSubArrayHelper(A, 0, len - 1);
    }

    //因为我们不知道max subarray到底包含了middle没有， 所以我们把三种情况都算出来
    //第一种：max subarray在mid的左边，第二种：在mid右边，第三种：包含了mid
    private static int maxSubArrayHelper(int[] A, int left, int right) {
        if (right == left) {
            return A[left];
        }
        // Step1. Select the middle element of the array.
        // So the maximum subarray may contain that middle element or not.
        int mid = left + (right - left) / 2;
        //Step 2.1 If the maximum subarray does not contain the middle element,
        //then we can apply the same algorithm to the the subarray to the left
        //of the middle element and the subarray to the right of the middle element.
        int leftAns = maxSubArrayHelper(A, left, mid);
        int rightAns = maxSubArrayHelper(A, mid + 1, right);
        //Step 2.2 If the maximum subarray does contain the middle element,
        //then the result will be simply the maximum suffix subarray of the
        //left subarray plus the maximum prefix subarray of the right subarray
        int leftMax = A[mid];
        int rightMax = A[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; i--) {
            temp += A[i];
            leftMax = Math.max(leftMax, temp);
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += A[i];
            rightMax = Math.max(rightMax, temp);
        }
        //Step 3 return the maximum of those three answer (max subarray in left half
        //, max subarray in right half and max subarray cross the middle point)
        return Math.max(Math.max(leftAns, rightAns), rightMax + leftMax);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(
                maxSubArray2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));

    }

}
