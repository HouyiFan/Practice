
public class Hamming_Distance_461 {

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        //解决不了x或y有负数的情况
        // while(xor != 0){
        //     count += xor & 1;
        //     xor >>= 1;
        // }

        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;

    }
    // 可以解决负数问题
    // int ans = 0;
    // while (x != 0 || y != 0) {
    //     if (x % 2 != y % 2) {
    //         ans++;
    //     }
    //     x = x / 2;
    //     y = y / 2;
    // }
    // return ans;

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
