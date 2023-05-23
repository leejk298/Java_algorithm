import java.util.*;

/*
4 5 1
1 2
1 3
1 4
2 4
3 4
 */

public class DFS와BFS_백준 {
    static int N, M, S; // 크기, 시작점
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 엣지
        S = sc.nextInt();   // 시작점

        A = new ArrayList[N + 1];   // 초기화

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 양방향
            A[e].add(s);
        }

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            Collections.sort(A[i]); // 오름차순 정렬, 노드번호가 낮은 것부터 탐색
    }

    public static void DFS(int v) { // DFS

        if(visited[v])  // 베이스케이스, 방문 했으면 리턴
            return;

        // 재귀케이스, 방문 안했으면
        visited[v] = true;  // 방문여부 갱신
        System.out.print(v + " ");  // 노드번호 출력

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 순회
            int next = A[v].get(i); // 다음 노드

            if(!visited[next])  // 방문하지 않았으면
                DFS(next);  // DFS
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer>queue = new LinkedList<>();   // 큐

        queue.offer(v); // 시작점 삽입
        visited[v] = true;  // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 현재 노드

            System.out.print(now + " ");    // 노드번호 출력

            for(int i = 0; i < A[now].size(); i++) {    // 인접리스트 순회
                int next = A[now].get(i);   // 다음 노드

                if(!visited[next]) {    // 방문하지 않았으면
                    visited[next] = true;   // 방문여부 갱신
                    queue.offer(next);  // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        visited = new boolean[N + 1];   // 방문배열 초기화
        DFS(S); // DFS
        System.out.println();   // 개행문자 출력

        visited = new boolean[N + 1];   // 방문배열 초기화
        BFS(S); // BFS
        System.out.println();   // 개행문자 출력
    }
}
