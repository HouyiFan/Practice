
public class Single_Number_136 {

    public int singleNumber(int[] nums) {
        // XOR bit manipulation
        // Intuition: A^A = 0, A^B^A = B
        // Time: O(n)
        // Space: O(1), no extra space
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;

        // Hashset
        // Time: O(n)
        // Space: O(s.length), could be O((n-1)/2 + 1), all non-repeat elements
        // HashSet<Integer> s = new HashSet<>();
        // for(int i : nums){
        //     if(!s.add(i)){
        //         s.remove(i);
        //     }
        // }
        // return s.iterator().next();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
