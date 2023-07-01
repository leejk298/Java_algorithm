import java.util.*;
import java.io.*;

public class 복습1_0701 {
    static int N, M, answer;    // 크기, 결과값
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init(int V, int[][] bridge) {    // 초기화

        N = V;  // 정점
        M = bridge.length;  // 엣지
        answer = 0; // 결과값

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {    // 엣지 개수만큼
            int S = bridge[i][0];   // 시작
            int E = bridge[i][1];   // 도착

            A[S].add(E);    // 양방향
            A[E].add(S);
        }
    }

    public static void DFS(int v) { // DFS

        if (visited[v])  // 방문한 적이 있으면
            return; // 리턴

        // 방문한 적이 없으면
        visited[v] = true;  // 방문

        for (int i = 0; i < A[v].size(); i++) {  // 인접리스트 개수만큼
            int next = A[v].get(i); // 다음 정점

            if (!visited[next])  // 방문하지 않았으면
                DFS(next);  // DFS
        }
    }

    public static void findBridgeMinCount() {   // 필요한 최소의 다리 개수

        int count = 0;  // 개수

        for (int i = 1; i <= N; i++) {   // 정점 개수만큼
            if (!visited[i]) {   // 방문한 적이 없으면
                DFS(i); // DFS
                count++;    // 연결요소 개수 카운트
            }
        }

        answer = count - 1; // (총 연결요소 개수) - 1 만큼 필요
    }

    public static int solution(int V, int[][] bridge) {

        init(V, bridge);    // 초기화

        findBridgeMinCount();   // 최소 다리 몇 개 필요한 지

        return answer;  // 결과값 리턴
    }

    public static void main(String[] args) {

        System.out.println(solution(6, new int[][]{{1, 2}, {2, 3}, {4, 5}}));
    }
}
