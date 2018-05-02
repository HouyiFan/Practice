
public class Search_a_2D_Matrix_II_240 {

    //Search from bottom-left to up-right
    //Time:O(m + n), since we search until reach the bound of matrix, in
    //worst case, we search until the up-rightmost point, which is O(m + n)
    //Space:O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        //Search from bottom-left to up-right
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j <= col - 1) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;

    }

    /**
     * @param matrix:
     *            A list of lists of integers
     * @param: A
     *             number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix1(int[][] matrix, int target) {
        // write your code here
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(searchMatrix(new int[][] { { 1, 4, 7 }, { 2, 5, 8 },
                { 3, 6, 9 }, { 10, 13, 14 }, { 18, 21, 23 } }, 5));
        System.out.println(searchMatrix(new int[][] { { 1, 4, 7 }, { 2, 5, 8 },
                { 3, 6, 9 }, { 10, 13, 14 }, { 18, 21, 23 } }, 6));
    }

}
