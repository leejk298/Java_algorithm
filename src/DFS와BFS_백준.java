import java.util.*;
import java.io.*;

/*
4 5 1
1 2
1 3
1 4
2 4
3 4
 */

public class DFS와BFS_백준 {
    static int N, M, start; // 크기, 시작점
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        start = Integer.parseInt(st.nextToken());   // 시작점

        A = new List[N + 1];    // 인접리스트
        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 구현

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작
            int e = Integer.parseInt(st.nextToken());   // 도착

            A[s].add(e);    // 양방향
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            Collections.sort(A[i]); // 번호 오름차순 정렬
    }

    public static void DFS(int v) { // DFS

        if (visited[v]) // 베이스케이스: 방문한 적이 있으면 리턴
            return;

        // 재귀케이스: 방문한 적이 없으면
        visited[v] = true;  // 방문
        System.out.print(v + " ");  // 번호 출력

        for (int next : A[v])   // 해당 정점의 인접리스트 순회
            if (!visited[next]) // 방문한 적이 없으면
                DFS(next);  // DFS, 재귀콜
    }

    public static void printDFS() { // DFS 경로 출력

        visited = new boolean[N + 1];   // 방문배열 초기화
        DFS(start); // 시작점으로 DFS
        System.out.println();   // 개행문자 출력
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 큐에 시작점 삽입
        visited[v] = true;  // 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어
            System.out.print(now + " ");    // 번호 출력

            for (int next : A[now]) {   // 해당 정점의 인접리스트 순회
                if (!visited[next]) {   // 방문한 적이 없으면
                    queue.offer(next);  // 큐에 삽입
                    visited[next] = true;   // 방문 여부 갱신
                }
            }
        }
    }

    public static void printBFS() { // BFS 경로 출력

        visited = new boolean[N + 1];   // 방문배열 초기화
        BFS(start); // 시작점으로 BFS
        System.out.println();   // 개행문자 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printDFS(); // DFS 경로 출력

        printBFS(); // BFS 경로 출력
    }
}
