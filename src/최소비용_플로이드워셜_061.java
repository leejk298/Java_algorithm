import java.util.*;
import java.io.*;

public class 최소비용_플로이드워셜_061 {
    static int N, M;    // 크기
    static int[][] A;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        N = Integer.parseInt(bf.readLine()); // 노드
        M = Integer.parseInt(bf.readLine()); // 엣지

        A = new int[N + 1][N + 1]; // 인접행렬 => 플로이드워셜은 N 이 작아야 쓸 수 있으므로

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            for (int j = 1; j <= N; j++) { // 2차 배열
                if (i == j) // S == E면 0
                    A[i][j] = 0;
                else // 이외에는 최대 비용보다 큰 수 설정
                    A[i][j] = 1000001;
            }
        }

        StringTokenizer st;

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            if (A[S][E] > W) // 이미 가중치가 있다면 작은 수로 설정
                A[S][E] = W;
        }
    }

    public static void FloydWarshall() { // 플로이드워셜 알고리즘 로직, 성능: O(V^3) => V: 노드 개수

        for (int k = 1; k <= N; k++) // 경유지 K에 대해
            for (int i = 1; i <= N; i++) // 출발노드 S에 대해
                for (int j = 1; j <= N; j++) // 도착노드 E에 대해
                    if (A[i][j] > A[i][k] + A[k][j]) // 경유지 K를 거치는 게 작으면
                        A[i][j] = A[i][k] + A[k][j]; // 업데이트

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            for (int j = 1; j <= N; j++) { // 2차 배열
                if (A[i][j] == 1000001) // 경로가 업데이트가 안된 경우
                    System.out.print("0 ");
                else // 업데이트가 된 경우
                    System.out.print(A[i][j] + " ");
            }

            System.out.println(); // 개행문자 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜 알고리즘
    }
}
