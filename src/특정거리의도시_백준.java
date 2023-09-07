import java.util.*;
import java.io.*;

/*
4 4 2 1
1 2
1 3
2 3
2 4
 */

public class 특정거리의도시_백준 {
    static int N, M, K, X;  // 크기, 거리, 시작도시
    static List<Integer>[] A;   // 인접리스트
    static int[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        K = Integer.parseInt(st.nextToken());   // 특정 거리
        X = Integer.parseInt(st.nextToken());   // 시작 도시

        // 초기화
        A = new ArrayList[N + 1];
        visited = new int[N + 1];

        for(int i = 1; i <= N; i++) {   // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현
            visited[i] = -1;    // -1로 초기화 => 거리가 1로 동일하므로 방문배열로 구현
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int start = Integer.parseInt(st.nextToken());   // 시작
            int end = Integer.parseInt(st.nextToken());     // 도착

            A[start].add(end);  // 인접리스트 저장
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 시작점 큐에 삽입
        visited[v] = 0; // 거리 0부터 시작

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for(int i = 0; i < A[now].size(); i++) {    // 인접리스트 개수만큼
                int next = A[now].get(i);   // 다음 도시

                if(visited[next] == -1) {   // 방문한 적이 없으면
                    visited[next] = visited[now] + 1;   // 방문, 거리 + 1
                    queue.offer(next);  // 큐에 삽입
                }
            }
        }
    }

    public static void printCity() {    // 도시 출력

        boolean flag = false;   // 특정 거리에 있는 도시 여부

        for(int i = 1; i <= N; i++) {   //  정점 개수만큼
            if(visited[i] == K) {   // 특정 거리에 도시가 있다면
                System.out.println(i);  // 해당 도시 출력
                flag = true;    // true
            }
        }

        if(!flag)   // 없다면
            System.out.println(-1); // -1 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS(X); // 시작점으로 BFS

        printCity();    // 특정 거리에 있는 도시 출력
    }
}
