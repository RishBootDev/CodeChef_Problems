import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (int it = 0; it < t; it++) {
            solve(scanner);
        }
        scanner.close();
    }

    public static void solve(Scanner scanner) {
        long n = scanner.nextLong();
        long[][] ar = new long[(int) n + 1][(int) n + 1];

        // Reading the input for the triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ar[i][j] = scanner.nextLong();
            }
        }

        long[][] dp = new long[(int) n + 1][(int) n + 1];

        for (int j = 1; j <= n; j++) {
            dp[(int) n][j] = ar[(int) n][j];
        }

        for (int i = (int) n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = ar[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[1][1]);
    }
}
