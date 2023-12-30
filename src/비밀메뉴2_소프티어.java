import java.util.*;
import java.io.*;


public class 비밀메뉴2_소프티어 {
    static int res; // 결과
    static int dp[][];  // dp 배열
    static int check[], A[];    // 방문, 거리배열

    public static int DFS(int i, int j) {   // DFS

        if (i < 0 || j < 0) // 베이스케이스
            return 0;

        if (dp[i][j] != 0)  // 메모이제이션
            return dp[i][j];

        if (check[i] == A[j])   // 같으면
            return dp[i][j] = 1 + DFS(i - 1, j - 1);    // dp 배열 갱신

        return dp[i][j];    // 해당 값 리턴
    }

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 초기화
        check = new int[N];
        A = new int[M];
        dp = new int[N][M];
        res = 0;

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for (int i = 0; i < N; i++) // 크기만큼
            check[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++)
            A[i] = Integer.parseInt(st.nextToken());

        for (int i = N - 1; i >= 0; i--)    // 행
            for (int j = M - 1; j >= 0; j--)    // 열
                res = Math.max(DFS(i, j), res); // 최대값 구하기

        System.out.println(res);    // 결과값 리턴
    }
}