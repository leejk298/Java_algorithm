import java.io.*;
import java.util.StringTokenizer;

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
 */

public class 구간합구하기5_백준 {
    static int N, M;    // 크기
    static int[][] map, dp; // 입력, dp 배열

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());   // 구간 개수

        // 초기화
        dp = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {  // 행
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= N; j++) {  // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 맵 저장
            }
        }

        for (int i = 1; i <= N; i++)    // 행
            for (int j = 1; j <= N; j++)    // 열
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];  // dp 점화식


        StringBuilder sb = new StringBuilder(); // 문자열 만들기
        for (int i = 0; i < M; i++) {   // 개수만큼
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());  // 좌표
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]).append("\n");    // 개행 추가
        }

        System.out.println(sb); // 결과값 출력
    }
}