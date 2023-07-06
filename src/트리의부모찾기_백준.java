import java.util.*;

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
    static int N;   // 노드
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] parent;    // 부모배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드 개수

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) // 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 1; i < N; i++) {    // N - 1
            int S = sc.nextInt();
            int E = sc.nextInt();

            A[S].add(E);    // 무방향
            A[E].add(S);
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 루트노드 삽입
        visited[v] = true;  // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for(int i : A[now]) {   // 인접리스트 순회
                if(!visited[i]) {   // 방문한 적이 없으면
                    visited[i] = true;  // 방문여부 갱신
                    parent[i] = now;    // 부모노드 저장
                    queue.offer(i);     // 큐에 삽입
                }
            }
        }
    }

    public static void printParent() {  // 부모노드 출력

        for(int i = 2; i <= N; i++) // 2번 노드부터
            System.out.println(parent[i]);  // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS(1); // 루트노드인 1번부터 BFS

        printParent();  // 부모노드 출력
    }
}
