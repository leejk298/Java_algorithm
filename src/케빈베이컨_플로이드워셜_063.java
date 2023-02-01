import java.util.*;
import java.io.*;

public class 케빈베이컨_플로이드워셜_063 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 엣지

        int A[][] = new int[N + 1][N + 1]; // 인접행렬

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            for (int j = 1; j <= N; j++) { // 2차 배열
                if (i == j) // S == E
                    A[i][j] = 0; // 0
                else // 그외에는 큰 수
                    A[i][j] = 100001;
            }
        }

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝

            A[S][E] = A[E][S] = 1; // 방향성 X -> 양방향 (서로 친구관계)
        }

        // 플로이드워셜 알고리즘 로직
        for (int k = 1; k <= N; k++) { // 경유지 K에 대해
            for (int i = 1; i <= N; i++) { // 출발노드 S
                for (int j = 1; j <= N; j++) { // 도착노드 E
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]); // 도달가능하면 최소값으로 설정
                }
            }
        }

        int min = Integer.MAX_VALUE; // 각 노드의 케빈베이컨 수
        int f = -1; // 가장 작은 노드찾기

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            int tmp = 0; // 행의 합 => 각 노드의 케빈베이컨 수

            for (int j = 1; j <= N; j++) { // 2차 배열
                tmp += A[i][j]; // 행의 합
            }

            if (min > tmp) { // 작으면
                min = tmp; // 해당 값으로 설정
                f = i; // 그때의 노드 번호
            }
        }

        System.out.println(f); // 출력
    }
}
