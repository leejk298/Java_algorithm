import java.util.*;

/*
3
5 3
3 2
2 6
 */

public class 행렬곱셈순서_백준 {
    static int N;   // 크기
    static int[][] map, dp; // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        map = new int[N][2];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {    // 크기만큼
            map[i][0] = sc.nextInt();   // 앞
            map[i][1] = sc.nextInt();   // 뒤
        }
    }

    public static void printMinMulti() {    // 곱셈 연산 최소값 출력

        for(int k = 1; k < N; k++) {    // 간격
            for(int i = 0; i < N - k; i++) {    // 시작
                dp[i][i + k] = Integer.MAX_VALUE;   // 최대값으로 설정

                for(int j = i; j < i + k; j++)  // 중간
                    dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] +
                            map[i][0] * map[j][1] * map[i + k][1]); // 최소값 찾기, 점화식
            }
        }

        System.out.println(dp[0][N - 1]);   // 최소값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinMulti();    // 곱셈 연산 최소값 출력
    }
}
