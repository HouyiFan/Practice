
public class Roll_Characters_Of_String {

    public static String rollTheString(String s, int[] roll) {
        int[] moves = new int[s.length()];
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] - 1 >= 0) {
                moves[roll[i] - 1]++;
            }
        }
        int sum = 0;
        for (int i = moves.length - 1; i >= 0; i--) {
            int temp = moves[i];
            moves[i] += sum;
            sum += temp;
        }
        char[] c = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z' };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moves.length; i++) {
            sb.append(c[((s.charAt(i) - 'a' + moves[i]) % 26)]);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String s = "zcza";

        // roll array
        int[] roll = { 1, 1, 3, 4, 1 };
        System.out.println(rollTheString(s, roll));

        int[] roll1 = { 0, 0 };
        System.out.println(rollTheString(s, roll1));

        //acza
        //bcza
        //cdaa
        //debb
        //eebb

    }

}
