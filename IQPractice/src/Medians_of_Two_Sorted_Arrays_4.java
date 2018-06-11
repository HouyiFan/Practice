
public class Medians_of_Two_Sorted_Arrays_4 {

    // Binary search
    // Time: O(log(m + n))
    // Space: O(log(m + n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if (total % 2 == 0) {
            return (getKth(nums1, 0, nums2, 0, total / 2 + 1)
                    + getKth(nums1, 0, nums2, 0, total / 2)) / 2.0;
        } else {
            return getKth(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    // k is 1-based, not 0-based
    // if aMid < bMid,then the max index of aMid in the mixed array is k-1,
    // because at most k/2-1 nums in B will insert into the place before
    // aMid when mix them,as k/2th element in B is larger than aMid.
    //当start1 + k / 2 - 1 >= nums1.length时，b[k/2-1]无论如何都不可能是第k个数，
    //所以把b的前半段扔掉
    private static int getKth(int[] nums1, int start1, int[] nums2, int start2,
            int k) {
        // If nums1 is exhausted, return kth number in nums2
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        // If nums2 is exhausted, return kth number in nums1
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        // If k == 1, return the first number
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //nums1 and nums2 are different size array, only if the index<array.Length,
        //the index will be valid, otherwise, set mid to int.Max to cut another
        //array since k must be in range another array[start + k / 2, ...]
        //[1]
        //[1, 2, 3, 4, 5, 6]
        int mid1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1]
                : Integer.MAX_VALUE;
        int mid2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1]
                : Integer.MAX_VALUE;

        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            //num1.right + nums2
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            //nums1 + nums2.right
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    // Optimized method - Binary search
    // Time: O(log(min(m, n)))
    // Space: O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int N1 = nums1.length, N2 = nums2.length;
        int total = N1 + N2;
        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (N1 == 0) {
            return (nums2[N2 / 2] + nums2[(N2 - 1) / 2]) / 2.0;
        }
        int cutL = 0, cutR = N1; // the range of cut1
        int cut1 = N1 / 2;
        int cut2 = total / 2 - cut1;

        while (cut1 <= N1) { //也可以用cutL <= cutR
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = total / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == N1) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == N2) ? Integer.MAX_VALUE : nums2[cut2];
            //L1 should <= R2, L2 should <= R1
            if (L1 > R2) { //cut1 左移
                cutR = cut1 - 1;
            } else if (L2 > R1) { //cut1 右移
                cutL = cut1 + 1;
            } else { //otherwise, cut1 is the right cut
                if (total % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2; //left
                    R1 = R1 < R2 ? R1 : R2; //right
                    return (L1 + R1) / 2;
                } else {
                    R1 = R1 < R2 ? R1 : R2; //规律
                    return R1;
                }
            }
        }
        return -1;
    }
}
