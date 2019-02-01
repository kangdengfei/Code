package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-17 23:37
 **/
public class Unique_Paths_II_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        if(obstacleGrid[0][0]==1)
            return 0;
        for(int i = 0;i<m;i++){
            if(obstacleGrid[i][0]==0)
                dp[i][0]=1;
            else{
                dp[i][0]=0;
                if(i<m-1)
                    obstacleGrid[i+1][0]=1;
            }

            dp[i][0]=0;
        }
        for(int j = 0;j<n;j++){
            if(obstacleGrid[0][j]==0)
                dp[0][j]=1;
            else{
                dp[0][j]=0;
                if(j<n-1)
                    obstacleGrid[0][j+1]=1;
            }

        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }

        }

        for (int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int [][] array = {{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(array);
        System.out.println(i);
    }
}


