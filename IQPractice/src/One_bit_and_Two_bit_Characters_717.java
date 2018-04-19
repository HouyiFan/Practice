
public class One_bit_and_Two_bit_Characters_717 {

    // Increment pointer
    // Time: O(n), could be less than n, but in the worst case it would be n.
    // e.g. bits = {0, 0, 0, 0, 0}
    // Space: O(1), the space used by i
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        int n = bits.length;
        if (n == 1) {
            return true;
        }
        int i;

        //即判断最后是｛1，0｝还是｛0｝
        for (i = 0; i < n - 1;) {
            // if the first is 1, then it must be {1, 1} or {1, 0}
            // so we add index by 2 to jump to the next character
            if (bits[i] == 1) {
                i += 2;
            } else if (bits[i] == 0) { // if the first is 0, then it is {0}
                i++;
            }
        }
        // if i is n - 1, then it must end with a 1-bit character
        return (i == n - 1);
    }

    // Greedy
    // 找到倒数第二个0，因为0肯定是一个character的结尾，所以倒数第二个0的下一位是一个新的character
    // 这样倒数第二个0和最后一个0（也就是数组最后一位）之间必须有偶数个1,
    // 这样｛1，1｝可以抵消，如果是奇数个1，则会剩一个1与最后一个0配对，即返回false
    // Time: O(n)
    // Space: O(1)
    public static boolean isOneBitCharacter1(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        int n = bits.length;
        if (n == 1) {
            return true;
        }
        int i = n - 2;
        //find the second-last 0
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        //only returns true when there are even number of 1 present between
        //the second-last 0 and last 0
        return (n - i) % 2 == 0;

    }

    public static void main(String[] args) {

        System.out.println(isOneBitCharacter(new int[] { 1, 0, 0 }));
        System.out.println(isOneBitCharacter(new int[] { 1, 1, 1, 0 }));
        System.out.println(isOneBitCharacter(new int[] { 1, 1, 0, 0 }));
        System.out.println(isOneBitCharacter1(new int[] { 1, 0, 1, 0 }));
        System.out.println(isOneBitCharacter1(new int[] { 1, 0, 1, 1, 0 }));

    }

}
