
public class Sum_of_Two_Integers_371 {

    // Time: O(1)
    // Space: O(1)
    public static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; //sum without adding carry-in
        int carry = (a & b) << 1; //carry-in
        return getSum(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 3)); // 5
        System.out.println(getSum(Integer.MIN_VALUE, Integer.MAX_VALUE)); // -1
        System.out.println(getSum(Integer.MAX_VALUE, Integer.MAX_VALUE)); // -2
    }

}
