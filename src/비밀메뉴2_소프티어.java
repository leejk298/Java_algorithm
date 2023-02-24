import java.util.*;
import java.io.*;


public class 비밀메뉴2_소프티어 {
    public static int res;
    public static int dp[][];
    public static int check[], A[];

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new int[N];
        A = new int[M];
        dp = new int[N][M];
        res = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N - 1; i >= 0; i--) {
            for(int j = M - 1; j >= 0; j--) {
                res = Math.max(dfs(i, j), res);
            }
        }

        System.out.println(res);
    }

    public static int dfs(int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        if(check[i] == A[j]) {
            return dp[i][j] = 1 + dfs(i-1, j-1);
        }

        return dp[i][j];
    }
}