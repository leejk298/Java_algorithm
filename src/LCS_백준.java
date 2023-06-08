import java.util.*;

/*
ACAYKP
CAPCAK
 */

public class LCS_백준 {
    static int r, c;    // 크기
    static int[][] dp;  // dp 배열
    static String a, b; // 입력 문자열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        a = sc.nextLine();  // 입력 문자열 1
        b = sc.nextLine();  // 2

        r = a.length(); // 문자열1 길이
        c = b.length(); // 2

        dp = new int[r + 1][c + 1]; // 초기화
    }

    public static void printLCS() { // 길이 출력

        for (int i = 1; i <= r; i++) {  // 행
            for (int j = 1; j <= c; j++) {  // 열
                if (a.charAt(i - 1) == b.charAt(j - 1)) // 같으면
                    dp[i][j] = dp[i - 1][j - 1] + 1;    // 대각선 + 1
                else    // 다르면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // 둘 중 큰 값
            }
        }

        System.out.println(dp[r][c]);   // LCS 최대 길이 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printLCS(); // 최대 길이 출력
    }
}
