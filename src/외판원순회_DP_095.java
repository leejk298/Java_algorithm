import java.util.*;
import java.io.*;

public class 외판원순회_DP_095 {
    static int INF; // 충분히 큰 초기화값
    static int N; // 도시 개수
    static int W[][]; // 비용
    static int D[][]; // 점화식

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        N = Integer.parseInt(bf.readLine()); // 개수

        W = new int[N][N]; // 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        INF = 1000000 * N + 1; // 초기화
        D = new int[N][1 << N]; // 1 << N = 10000(2) = 16
        for (int i = 0; i < N; i++) // 초기화
            for (int j = 0; j < (1 << N); j++)
                D[i][j] = INF;

        System.out.println(tsp(0, 1)); // 0번 도시부터 시작, 00001 => 1번 도시 방문
    }

    private static int tsp(int c, int v) { // 최소비용 찾기
        if (v == (1 << N) - 1) // 전부 방문 하면 01111(2) = 15 = 16 - 1
            return W[c][0] == 0 ? INF : W[c][0]; // 0이면 시작도시로 못돌아오는 것, 0이 아니면 그대로 값 리턴

        if (D[c][v] != INF) // 초기화값이 아니면 재계산 필요 X
            return D[c][v]; // 변경된 값 그대로 리턴 => 메모이제이션

        for (int i = 0; i < N; i++) // 도시 개수만큼
            if ((v & (1 << i)) == 0 && W[c][i] != 0) // (비트연산)방문한 적이 없고 갈 수 있는 경로(유효한 값)이면
                // (원래 값, (해당 도시 방문 이전의 비용 + 해당 도시방문 비용)) 최소비용계산
                D[c][v] = Math.min(D[c][v], tsp(i, (v | (1 << i))) + W[c][i]); // 재귀콜

        return D[c][v]; // 최소비용 리턴
    }
}
