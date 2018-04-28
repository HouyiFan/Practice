
public class Maximum_Product_Subarray_152 {

    // DP Solution
    // Time: O(n)
    // Space: O(n)
    public static int maxProduct(int[] A) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        int max = A[0];
        int[] dpMax = new int[A.length]; //the max product ending with A[i]
        int[] dpMin = new int[A.length]; //the min product ending with A[i]
        dpMax[0] = A[0];
        dpMin[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dpMax[i] = Math.max(
                    Math.max(dpMax[i - 1] * A[i], dpMin[i - 1] * A[i]), A[i]);
            dpMin[i] = Math.min(
                    Math.min(dpMin[i - 1] * A[i], dpMax[i - 1] * A[i]), A[i]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    // Two scans to solve odd negative numbers case.
    //if A has odd negative numbers, scan twice. If A has
    //even negative numbers, scan one time is enough.
    // Time: O(n)
    // Space: O(1)
    public static int maxProduct1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        int max = Integer.MIN_VALUE;
        int multi = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, multi *= A[i]);
            if (A[i] == 0) {
                multi = 1;
            }
        }
        multi = 1;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, multi *= A[i]);
            if (A[i] == 0) {
                multi = 1;
            }
        }
        return max;
    }

    // without DP Solution
    // Time: O(n)
    // Space: O(1)
    public static int maxProduct2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int dpMax = A[0]; //the max product ending with A[i]
        int dpMin = A[0]; //the min product ending with A[i]
        dpMax = A[0];
        dpMin = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = dpMax; // Since the dpMax may be changed in the next line
            //use temp to keep dpMax ending with A[i - 1]
            dpMax = Math.max(Math.max(dpMax * A[i], dpMin * A[i]), A[i]);
            dpMin = Math.min(Math.min(dpMin * A[i], temp * A[i]), A[i]);
            max = Math.max(max, dpMax);
        }
        return max;
    }

    // without DP Solution
    // Time: O(n)
    // Space: O(1)
    public static int maxProduct3(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int imax = A[0];
        int imin = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                //if A[i] is negative, swap imax with imin
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct3(new int[] { -3, -4 }));
        System.out.println(maxProduct3(new int[] { 3, -6, 4 }));
        System.out.println(maxProduct3(new int[] { 2, 3, -2, 4, -4 }));
        System.out.println(maxProduct3(new int[] { 2, 3, -2, 4, -4, 0 }));

    }

}
