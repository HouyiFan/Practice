
public class Max_Area_of_Island_695 {
    // dfs
    // Time: O(row * col), two for loop
    // Space: O(row * col), because "visited"
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = grid[i][j];
                if (x == 1 && !visited[i][j]) {
                    int temp = this.dfs(i, j, grid, visited);
                    area = Math.max(area, temp);
                }
            }
        }
        return area;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            return 1 + this.dfs(i - 1, j, grid, visited)
                    + this.dfs(i + 1, j, grid, visited)
                    + this.dfs(i, j - 1, grid, visited)
                    + this.dfs(i, j + 1, grid, visited);
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
