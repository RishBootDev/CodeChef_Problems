import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static final long MOD = 1000000007; 
    static final long INF = 1000000000000000000L; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); 

        int[] fees = new int[n]; 
        for (int i = 0; i < n; i++) {
            fees[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(fees[0]);
            return;
        }
        if (n == 2) {
            System.out.println(fees[0] + fees[1]);
            return;
        }

        int[][] dp = new int[n][3];
        dp[0][1] = dp[0][2] = fees[0]; 
        dp[1][0] = fees[0];
        dp[1][1] = fees[1];
        dp[1][2] = fees[0] + fees[1];

        for (int i = 2; i < n; i++) {
          
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            
            dp[i][1] = fees[i] + dp[i - 1][0];
           
            dp[i][2] = fees[i] + fees[i - 1] + dp[i - 2][0];
        }

        System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
        

    }
}
