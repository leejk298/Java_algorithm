import java.io.*;
import java.util.*;

public class 점프점프_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] >= Integer.MAX_VALUE)
                continue;

            for(int j = 0; j <= arr[i]; j++) {
                if (i + j >= N)
                    break;

                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if(dp[N - 1] >= Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[N - 1]);
    }
}
