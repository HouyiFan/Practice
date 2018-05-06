import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
    // Two hashset
    // Time: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                intersect.add(i);
            }
        }
        int[] res = new int[intersect.size()];
        int index = 0;
        for (int i : intersect) {
            res[index++] = i;
        }
        return res;
    }

    // Binary Search and one set (Still need sort one array)
    // Time: O(nlogn)
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int i : nums1) {
            if (this.binarySearch(i, nums2)) {
                set.add(i);
            }
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (int i : set) {
            res[index++] = i;
        }
        return res;
    }

    private boolean binarySearch(int i, int[] nums2) {
        if (nums2.length == 0) {
            return false;
        }
        int start = 0, end = nums2.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums2[mid] == i) {
                return true;
            } else if (nums2[mid] > i) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (nums2[start] == i) {
            return true;
        }

        if (nums2[end] == i) {
            return true;
        }

        return false;
    }

    // Sort both arrays, use two pointers
    // Time: O(nlogn)
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> temp = new HashSet<>();

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                temp.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[temp.size()];
        int index = 0;
        for (int e : temp) {
            res[index++] = e;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
