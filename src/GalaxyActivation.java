import java.util.Scanner;

public class GalaxyActivation {
    static int N;   // 크기
    static int[][] agents;  // 입력배열

    public static int findMinDestruction() {

        int[][][] dp = new int[N + 1][N + 1][N + 1];  // 0: 초기 상태, 1: 힘 선택, 2: 지능 선택, 3: 민첩 선택

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                for (int k = 0; k <= N; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;    // 초기화

        dp[0][0][0] = 0;    // 초기값

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (dp[i][j][k] != Integer.MAX_VALUE) {
                        dp[i + 1][j][k] = Math.min(dp[i + 1][j][k], dp[i][j][k] + agents[i][1] + agents[i][2]);
                        dp[i][j + 1][k] = Math.min(dp[i][j + 1][k], dp[i][j][k] + agents[i][0] + agents[i][2]);
                        dp[i][j][k + 1] = Math.min(dp[i][j][k + 1], dp[i][j][k] + agents[i][0] + agents[i][1]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE; // 최소값
        for(int i = 0; i <= N; i++)
            for(int j = 0; j <= N; j++)
                for(int k = 0; k <= N; k++)
                    if((i + j + k == N) && (i >= 1 && j >= 1 && k >= 1))
                        result = Math.min(result, dp[i][j][k]);

        return result != Integer.MAX_VALUE ? result : -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int T = sc.nextInt();   // 테스트케이스 개수
        StringBuilder sb = new StringBuilder(); // 결과문자열

        for (int t = 1; t <= T; t++) {  // 개수만큼
            N = sc.nextInt();   // 크기
            agents = new int[N][3]; // 입력배열 초기화

            for (int i = 0; i < N; i++) // 행
                for (int j = 0; j < 3; j++) // 열
                    agents[i][j] = sc.nextInt();    // 입력배열 저장

            int result = findMinDestruction();  // 결과값

            sb.append("#" + t + " " + result + "\n");   // 추가
        }

        System.out.print(sb);   // 출력
    }
}
