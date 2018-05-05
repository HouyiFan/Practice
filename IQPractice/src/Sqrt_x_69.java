
public class Sqrt_x_69 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res;
        int start = 1, end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start <= x / start) {
            res = start;
        } else {
            res = end;
        }
        return res;
    }

    //Faster implementation
    public static int mySqrt1(int x) {

        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(mySqrt(1));

    }

}
