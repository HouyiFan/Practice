
public class Pow_50 {

    // recursive method
    // Time: O(logn)
    // Space: O(logn)
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double half = this.myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return n > 0 ? x * half * half : 1 / x * half * half;
        }
    }

    // another recursive method
    // Time: O(logn)
    // Space: O(logn)
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n == Integer.MIN_VALUE) { // avoid overflow
            n = n / 2;
            x = x * x;
        }
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }

        if (n % 2 == 0) {
            return this.myPow1(x * x, n / 2);
        } else {
            return this.myPow1(x * x, n / 2) * x;
        }
    }
}
