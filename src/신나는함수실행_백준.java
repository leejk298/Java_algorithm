import java.util.*;
import java.io.*;

/*
1 1 1
2 2 2
10 4 6
50 50 50
-1 7 18
-1 -1 -1
 */

public class 신나는함수실행_백준 {
    static int a, b, c; // 숫자
    static int[][][] dp;    // DP 배열

    public static boolean isValidPos(int a, int b, int c) { // 값이 유효한지
        return (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20);
    }

    public static int w(int a, int b, int c) {  // w 함수

        if (isValidPos(a, b, c) && dp[a][b][c] != 0)    // 메모이제이션
            return dp[a][b][c]; // 이미 계산되어 있는 경우, 그대로

        if (a <= 0 || b <= 0 || c <= 0) // 0 이하이면 1
            return 1;

        if (a > 20 || b > 20 || c > 20) // 20 초과이면
            return dp[20][20][20] = w(20, 20, 20);

        if (a < b && b < c) // a < b < c
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));    // 입력 버퍼
        StringTokenizer st;
        dp = new int[21][21][21];   // 초기ㅗ하

        while (true) {
            st = new StringTokenizer(bf.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)  // 전부 -1이면 while 종료
                break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));   // 출력
        }
    }
}
