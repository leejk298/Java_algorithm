import java.util.*;

public class 너비우선탐색_백준 {
    static int N, M, S, num;    // 크기, 시작점, 탐색 순서
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] order; // 탐색 순서배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지
        S = sc.nextInt();   // 시작점
        num = 1;    // 탐색 순서

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for(int i = 1; i <= N; i++) // 노드 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 무방향
            A[e].add(s);
        }

        for(int i = 1; i <= N; i++) // 노드 개수만큼
            Collections.sort(A[i]); // 오름차순 정렬, 작은 노드부터 시작하게끔
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 시작점 삽입
        visited[v] = true;  // 방문여부 갱신
        order[v] = num++;   // 탐색 순서 저장

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for(int i = 0; i < A[now].size(); i++) {    // 인접리스트 순회
                int next = A[now].get(i);   // 다음 노드

                if(!visited[next]) {    // 방문하지 않았으면
                    visited[next] = true;   // 방문여부 갱신
                    order[next] = num++;    // 탐색 순서 저장
                    queue.offer(next);  // 큐에 삽입
                }
            }
        }
    }

    public static void printOrder() {   // 탐색 순서 출력

        for(int i = 1; i <= N; i++) // 노드 개수만큼
            System.out.println(order[i]);   // 출력, 방문안했으면 0
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS(S); // BFS

        printOrder();   // 탐색 순서 출력
    }
}
