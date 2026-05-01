public class SCS {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            } else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        System.out.println(scs.reverse().toString());
    }
                  }
