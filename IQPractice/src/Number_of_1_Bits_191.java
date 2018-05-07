
public class Number_of_1_Bits_191 {

    // Time: O(1)
    // Space: O(1)
    public static int hammingWeight(int n) {
        int count = 0;
        // 不能用，因为test case里有超过Integer.MAX_VALUE的input
        // while(n != 0){
        //     if(n % 2 != 0){
        //         count++;
        //     }
        //     n /= 2;
        // }

        while (n != 0) {
            count += n & 1;
            n >>>= 1; // n = n >>> 1
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(hammingWeight(7));
        System.out
                .println(hammingWeight(Integer.parseUnsignedInt("4294967295")));
    }

}
