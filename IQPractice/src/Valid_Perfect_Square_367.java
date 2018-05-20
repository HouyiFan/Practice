
public class Valid_Perfect_Square_367 {

    // Time: O(logn)
    // Space: O(1)
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long low = 1; // use long to avoid type casting
        long high = num; // (num / 2 + 1) 也行，运行会更快
        while (low + 1 < high) {
            long mid = low + (high - low) / 2; // use long to avoid overflow if num is very large
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (low * low == num || high * high == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); // True
        System.out.println(isPerfectSquare(14)); // False
    }

}
