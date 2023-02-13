import java.util.*;

public class 사전찾기_조합_082 {
    static int N, M, K; // a 개수, z 개수, 몇 번째 문자열
    static int D[][]; // 조합

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        D = new int[N + M + 1][N + M + 1]; // 조합배열 초기화: 크기: N + M + 1 => N + M까지 포함해야하므로
        for (int i = 0; i <= N + M; i++) {
            D[i][0] = 1; // i개중 0개: 1
            D[i][i] = 1; // i개중 i개: 1
            D[i][1] = i; // i개중 1개: i
        }

        for (int i = 3; i <= N + M; i++) { // 총 남은 개수
            for (int j = 2; j < i; j++) { // 남은 z 개수 => a 먼저 뽑기(사전 순)
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j]; // 조합: 순서 X
                if (D[i][j] > 1000000000) // 최대값 넘을 때
                    D[i][j] = 1000000001;
            }
        }

        if (D[N + M][M] < K) // 문자열의 개수가 K보다 작은 경우 -1 출력
            System.out.println("-1");
        else {
            while (!(N == 0 && M == 0)) { // 다 뽑기 전까지 반복
                if (D[N - 1 + M][M] >= K) { // K번째 수 보다 a 뽑았을 때 남은 경우의 수가 큰 경우
                    System.out.print("a"); // a 확정
                    N--; // a 개수 갱신
                } else { // K번째 수가 a 뽑았을 때 남은 경우의 수 보다 큰 경우
                    System.out.print("z"); // z 확정
                    K = K - D[N - 1 + M][M]; // K 값 갱신 => z가 기준이므로
                    M--; // m 개수 갱신
                }
            }
        }
    }
}
