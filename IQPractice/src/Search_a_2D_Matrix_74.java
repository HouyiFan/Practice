
public class Search_a_2D_Matrix_74 {

    //An m×n matrix has m rows and n columns.
    //Binary search for row, then binary search for column,
    //Time: O(log(m * n)) , since log(m) + log(n) = log(m * n)
    //Space: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        //if the matrix is not valid
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        //if the target exceeds the range of matrix
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        //Find the row
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= matrix[mid][0]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target >= matrix[end][0]) {
            row = end;
        } else if (target >= matrix[start][0]) {
            row = start;
        } else {
            return false;
        }

        //Find the column
        start = 0;
        end = col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= matrix[row][mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == matrix[row][end]) {
            return true;
        } else if (target == matrix[row][start]) {
            return true;
        } else {
            return false;
        }
    }

    //Just one binary search, treat the matrix as a sorted list
    //Time:O(log(m * n))
    //Space: O(1)
    //One shortcoming: when we assign row * end - 1 to end, it may produce
    //overflow
    public static boolean searchMatrix1(int[][] matrix, int target) {
        //if matrix is not valid
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0, end = row * col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid / col][mid % col];
            if (number == target) {
                return true;
            } else if (number > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end / col][end % col] == target) {
            return true;
        } else if (matrix[start / col][start % col] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(
                searchMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 4));
        System.out.println(
                searchMatrix(new int[][] { { 1, 2, 3 }, { 5, 7, 8 } }, 6));

    }

}
