import java.util.HashMap;
import java.util.Map;

public class Degree_of_an_Array_697 {

    // Store a array int[] {degree, start pos, end pos}
    // Time: O(n)
    // Space: O(n)
    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int deg = 0;
        //        ArrayList<Integer> keys = new ArrayList<>();
        int start = 0;
        int end = 0;
        int len = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (map.containsKey(e)) {
                map.put(e, new int[] { map.get(e)[0] + 1, map.get(e)[1], i });
            } else {
                map.put(e, new int[] { 1, i, i });
            }
        }

        for (int[] val : map.values()) {
            if (val[0] > deg) {
                deg = val[0];
                start = val[1];
                end = val[2];
                len = end - start + 1;
            } else if (val[0] == deg) {
                len = Math.min(len, val[2] - val[1] + 1);
            }
        }

        return len;
    }

    // Using three map: left, right and count
    // Time: O(n)
    // Space: O(n), the space used by left, right and count
    public static int findShortestSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int deg = 0;
        int len = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (!left.containsKey(e)) {
                left.put(e, i);
            }
            right.put(e, i);
            count.put(e, count.getOrDefault(e, 0) + 1);
        }

        for (int e : nums) {
            if (count.get(e) > deg) {
                deg = count.get(e);
                len = right.get(e) - left.get(e) + 1;
            } else if (count.get(e) == deg) {
                len = Math.min(len, right.get(e) - left.get(e) + 1);
            }
        }

        return len;
    }

    // using three hash table: left, right, count
    // Time: O(n)
    // Space: O(m), it depends on the maximum number m in nums
    public static int findShortestSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxNumber = 0;
        for (int e : nums) {
            maxNumber = Math.max(maxNumber, e);
        }
        int deg = 0;
        int len = nums.length;
        int[] count = new int[maxNumber + 1];
        int[] left = new int[maxNumber + 1];
        int[] right = new int[maxNumber + 1];

        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (count[e] == 0) {
                left[e] = i;
            }
            right[e] = i;
            count[e]++;
        }
        for (int c : count) {
            deg = Math.max(deg, c);
        }

        for (int e : nums) {
            if (count[e] == deg) {
                len = Math.min(len, right[e] - left[e] + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findShortestSubArray2(new int[] { 1, 2, 2, 3, 1 }));
        System.out.println(
                findShortestSubArray2(new int[] { 1, 2, 2, 3, 1, 4, 2 }));

    }

}
