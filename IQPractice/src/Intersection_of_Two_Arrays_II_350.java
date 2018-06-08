import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection_of_Two_Arrays_II_350 {

    // HashMap
    // Time: O(n)
    // Space: O(n)
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] intersection = new int[res.size()];
        int index = 0;
        for (int e : res) {
            intersection[index++] = e;
        }
        return intersection;
    }

    // Sort and two pointers
    // Time: O(nlogn)
    // Space: O(n)
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] intersection = new int[res.size()];
        int index = 0;
        for (int e : res) {
            intersection[index++] = e;
        }
        return intersection;
    }
}
