
public class Nth_Digit_400 {
    /**
     * MebiuW: 这里是找第n个数字(这里的数和数字有区别，数字可以理解为将所有数拼合成一个字符串后的第n为对应的数字（0-9)）
     * 这里首先分析一下位数和规律 个位数： 1-9，一共9个,共计9个数字 2位数：10-99,一共90个，共计180个数字
     * 3位数：100-999，一共900个，共计2700个数字 4位数，1000-9999，一共9000个，共计36000个数字 以此类推，
     * 这样我们就可以首先定位到是哪个数，再找到其对应的数字
     */
    public static int findNthDigit(int n) {
        int start = 1;
        int len = 1;
        long num = 9; //防溢出

        //定位到是几位数
        while (n > len * num) {
            n -= len * num;
            len++; //len 用来记录target 数的长度
            num *= 10;
            start *= 10; //循环的时候不用，等会用来重组target 数
        }
        //定位到是这些几位数里面的第几个的第几位
        //start = (int)Math.pow(10, len - 1)
        //减1是因为start 自己算一个数，要把start 从计算中抠掉
        int range = (n - 1) / len; //不算10，100，1000; 比如找第10个数，不减1的话会找到下一个数
        int index = (n - 1) % len;
        //还原数字
        int target = start + range;
        int res = Integer.toString(target).charAt(index) - '0';
        return res;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(179));
    }

}
