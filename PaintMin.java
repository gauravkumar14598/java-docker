public class PaintMin {

    public static void main(String[] args) {
        int[][] arr = {{8, 3, 12, 5}, {15, 9, 4, 7}};
        int n = arr.length;
        int k = arr[0].length;

        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                dp[i][j] = -1;
            }
        }

        for(int j = 0; j < arr[0].length; j++) {
            ans = Math.min(ans, getMinCost(arr, n - 1, j, dp));
        }
        System.out.println(ans);
    }

    public static int getMinCost(int[][] paint, int row, int precol, int[][] dp) {
        if(row == 0) return paint[row][precol];
        if(dp[row][precol] != -1) return dp[row][precol];

        int mincost = Integer.MAX_VALUE;

        for(int j = 0; j < paint[0].length; j++) {
            if(j == precol) continue;
            mincost = Math.min(mincost, getMinCost(paint, row - 1, j, dp));
        }
        return dp[row][precol] = mincost + paint[row][precol];
    }
}
