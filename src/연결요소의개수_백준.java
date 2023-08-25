import java.util.*;
import java.io.*;

/*
6 5
1 2
2 5
5 1
3 4
4 6
 */

public class 연결요소의개수_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new List[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            A[S].add(E);    // 양방향
            A[E].add(S);
        }
    }

    public static void DFS(int v) { // DFS

        // 베이스케이스
        if(visited[v])  // 방문한 적이 있으면 건너뛰기
            return;

        // 재귀케이스
        visited[v] = true;  // 방문한 적이 없으면 방문

        for(int i = 0; i < A[v].size(); i++) {  // 해당 노드의 인접리스트 개수만큼
            int next = A[v].get(i); // 다음 노드

            if(!visited[next])  // 방문한 적이 없으면
                DFS(next);  // DFS, 재귀콜
        }
    }

    public static void printCount() {   // 연결요소 개수 출력

        int count = 0;  // 연결요소 개수

        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            if(!visited[i]) {   // 방문한 적이 없으면
                DFS(i);     // DFS
                count++;    // 개수 카운트
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCount();   // 연결요소 개수 출력
    }
}
