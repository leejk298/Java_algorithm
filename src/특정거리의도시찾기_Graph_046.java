import java.util.*;

public class 특정거리의도시찾기_Graph_046 {
    static int N, M, K, X;
    static int[] visited;
    static ArrayList<Integer>[] A;
    static List<Integer> res;

    public static void init() {

        Scanner sc = new Scanner(System.in); // 입력

        N = sc.nextInt(); // 노드 개수
        M = sc.nextInt(); // 엣지 개수
        K = sc.nextInt(); // 최단 거리
        X = sc.nextInt(); // 시작 노드

        visited = new int[N + 1]; // 방문 배열, 크기: N + 1 => 1번 노드부터 시작
        A = new ArrayList[N + 1]; // 인접리스트
        res = new ArrayList<>(); // 결과리스트

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            A[i] = new ArrayList<Integer>(); // 인접리스트 생성

            visited[i] = -1; // 방문 배열 초기화
        }

        for (int i = 0; i < M; i++) { // 에지 개수만큼
            int S = sc.nextInt(); // 시작
            int E = sc.nextInt(); // 끝

            A[S].add(E); // 방향성 그래프
        }
    }

    public static void BFS(int v, ArrayList<Integer>[] A, int[] visited) { // BFS

        Queue<Integer> queue = new LinkedList<>(); // 큐로 구현

        queue.add(v); // 우선 방문 노드 큐에 삽입
        visited[v]++; // 방문 배열값도 설정 => 가중치가 전부 1이므로 ++; (가중치 없는 그래프)

        while (!queue.isEmpty()) { // 비어있지 않으면
            int now_node = queue.poll(); // 큐에서 하나 꺼내어

            for (int i : A[now_node]) { // 해당 노드를 순회하여
                if (visited[i] == -1) { // 방문하지 않은 노드가 있으면
                    visited[i] = visited[now_node] + 1; // 해당 노드의 방문 배열을 갱신 => 현재 노드 + 1 => 최단경로

                    queue.add(i); // 큐에 삽입
                }
            }
        }
    }

    public static void printShortestCity() {

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            if (visited[i] == K) // 방문 배열의 값이 찾는 최단경로이면
                res.add(i); // 결과 리스트에 저장

        if (res.isEmpty()) // 결과 리스트가 비어있으면
            System.out.println(-1); // -1 출력

        else { // 비어있지 않으면
            Collections.sort(res); // 결과 리스트 정렬 => 오름차순 출력 위해

            for (int i : res) // 결과 리스트를 순회하면서
                System.out.println(i); // 출력
        }
    }

    public static void main(String[] args) {

        init();

        BFS(X, A, visited); // BFS 수행 - 최단경로 탐색

        printShortestCity();
    }
}
