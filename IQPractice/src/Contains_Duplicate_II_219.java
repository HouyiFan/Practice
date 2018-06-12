import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_Duplicate_II_219 {

    // Hash table and a sliding window
    // Time: O(n)
    // Space: O(min(n, k))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // Hash map
    // Time: O(n)
    // Space: O(n) in worst case (nums doesn't contain duplicate element)
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(x)) {
                if (i - map.get(x) <= k) {
                    return true;
                }
            }
            map.put(x, i);
        }
        return false;
    }
}
