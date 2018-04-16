import java.util.Scanner;

public class Convert_Decimal_To_Binary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        int n = (int) num;
        double decimal = num - n;
        String res = "";
        while (n > 0) {
            int remainder = n % 2;
            n = n / 2;
            res = remainder + res;
        }
        res += ".";

        while (decimal > 0) {
            decimal *= 2;
            int integer = (int) decimal;
            if (integer == 1) {
                decimal -= 1;
            }
            res += integer;
        }
        System.out.println(res);
        in.close();
    }

    //Given a base- integer, , convert it to binary (base-). Then find and
    //print the base- integer denoting the maximum number of consecutive 's in 's binary representation.
    //ex: 5 -> 101 -> 1
    //ex2: 13 -> 1101 -> 2
    //    public static void main(String[] args) {
    //        // TODO Auto-generated method stub
    //        Scanner in = new Scanner(System.in);
    //        int n = in.nextInt();
    //        String res = "";
    //        while (n > 0) {
    //            int remainder = n % 2;
    //            n = n / 2;
    //            res = remainder + res;
    //        }
    //        int count = 0;
    //        char[] c = res.toCharArray();
    //        for (int i = 0; i < c.length; i++) {
    //            int j = i;
    //            int temp = 0;
    //            while (i < c.length && c[i] == '1') {
    //                temp++;
    //                i++;
    //                count = Math.max(count, temp);
    //            }
    //            i = j;
    //        }
    //        System.out.println(count);
    //        in.close();
    //
    //    }

}
