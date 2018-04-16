import java.util.Scanner;

//To compute the max sum of a hourglass in a 2D array
public class Array2D_Hourglass_Problem {

    public static void main(String[] args) {
        // Sample Input
        //        1 1 1 0 0 0
        //        0 1 0 0 0 0
        //        1 1 1 0 0 0
        //        0 0 2 4 4 0
        //        0 0 0 2 0 0
        //        0 0 1 2 4 0
        //Sample Output
        //19
        //        Since
        //        2 4 4
        //        2
        //        1 2 4

        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i + 2 < arr[0].length; i++) {
            for (int j = 0; j + 2 < arr.length; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
                        + arr[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
        in.close();

    }

}
