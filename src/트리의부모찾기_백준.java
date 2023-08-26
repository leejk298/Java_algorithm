import java.util.*;
import java.io.*;

/*
7
1 6
6 3
3 5
4 1
2 4
4 7
 */

public class 트리의부모찾기_백준 {
    static int N;   // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] parent;    // 부모배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        // 초기화
        A = new List[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) // 크기만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 1; i < N; i++) {    // N - 1
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            A[S].add(E);    // 양방향
            A[E].add(S);
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 시작점 추가
        visited[v] = true;  // 시작점부터 방문

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for(int i = 0; i < A[now].size(); i++) {    // 해당 노드의 인접리스트 개수만큼
                int next = A[now].get(i);   // 다음 노드

                if(!visited[next]) {    // 방문한 적이 없으면
                    visited[next] = true;   // 방문
                    parent[next] = now;     // 부모 노드 설정
                    queue.offer(next);     // 큐에 삽입
                }
            }
        }
    }

    public static void printParent() {  // 부모 노드 출력

        for(int i = 2; i <= N; i++) // 2번 노드부터
            System.out.println(parent[i]);  // 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS(1); // BFS, 1번 노드부터 시작

        printParent();  // 부모 노드 출력
    }
}
