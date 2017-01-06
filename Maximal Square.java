// 动态规划算法+滚动数组：
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        if(m==0) return 0;
//        int[][] f= new int[n+1][m+1];// 表示矩阵边长的二维数组
        int[][] f = new int[2][m+1];
        int ans =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]==0)f[i%2][j]=0;
                else{
                    f[i%2][j]= Math.min(f[(i-1)%2][j-1],Math.min(f[(i-1)%2][j],f[i%2][j-1]))+1;
//                    f[i][j]= Math.min(f[i-1][j-1],Math.min(f[i-1][j],f[i][j-1]))+1;
                // f[i][j]的边长由他相邻的三个位置的最小边长决定的
                }
                if(f[i%2][j]>ans)ans=f[i%2][j];
            }
        }
        return ans*ans;
    }
}
///////////////////////////////////////////////////// 普通算法
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        if(m==0) return 0;
        int[][] f= new int[n+1][m+1];// 表示矩阵边长的二维数组
        int ans =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]==0)f[i][j]=0;
                else{
                    f[i][j]= Math.min(f[(i-1)][j-1],Math.min(f[(i-1)][j],f[i][j-1]))+1;
//                    f[i][j]= Math.min(f[i-1][j-1],Math.min(f[i-1][j],f[i][j-1]))+1;
                // f[i][j]的边长由他相邻的三个位置的最小边长决定的
                }
                if(f[i][j]>ans)ans=f[i][j];
            }
        }
        return ans*ans;
    }
}