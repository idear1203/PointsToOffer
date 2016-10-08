public class Solution{
  int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
  void printMatrix(int[][] matrix){
    int m = matrix.length;
    if (m == 0){
      return;
    }

    int n = matrix[0].length;
    if (n == 0){
      return;
    }
    
    int total = m * n;
    int count = 0;
    int row = 0;
    int col = 0;
    int dirIndex = 0;
    boolean[][] visit = new boolean[m][n];
    while (count < total){
      if (!isValid(visit, m, n, row, col)){
        row -= dirs[dirIndex][0];
        col -= dirs[dirIndex][1];
        dirIndex = (dirIndex + 1) % 4;
        row += dirs[dirIndex][0];
        col += dirs[dirIndex][1];
      }

      if (count != 0){
        System.out.printf(" "); 
      }

      System.out.printf("%d", matrix[row][col]);
      visit[row][col] = true;
      row += dirs[dirIndex][0];
      col += dirs[dirIndex][1];
      count++;
    }

    System.out.println();
  }

  private boolean isValid(boolean[][] visit, int m, int n, int row, int col){
    return row >= 0 && row < m && col >= 0 && col < n && !visit[row][col];
  }

  public static void main(String[] args){
    Solution sol = new Solution();
    int[][] matrix = { {1, 2, 3, 4},  {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
    sol.printMatrix(matrix);
  }
}
