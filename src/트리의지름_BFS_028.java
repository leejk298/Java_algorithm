import java.util.*;

public class 트리의지름_BFS_028 {
    static int N;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] A;

    static class Edge { // Edge 클래스 - 멤버변수 + 멤버함수
        // 멤버변수
        int e, w;

        // 멤버함수
        public Edge(int e, int w) { // 파라미터 생성자
            this.e = e;
            this.w = w;
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in); // 입력

        N = sc.nextInt(); // 노드 개수

        visited = new boolean[N + 1]; // 방문배열
        distance = new int[N + 1]; // 거리배열
        A = new ArrayList[N + 1]; // 노드마다 인접리스트 구현

        for (int i = 1; i <= N; i++) // 노드 1부터 시작 N개 만큼
            A[i] = new ArrayList<Edge>(); // 인접리스트 부착

        for (int i = 0; i < N; i++) { // N개 만큼 인접리스트 정보 저장 -> 무방향가중치그래프
            int S = sc.nextInt(); // 시작점

            while (true) {
                int E = sc.nextInt(); // 끝점

                if (E == -1) // -1 이면 반복문 종료
                    break;

                int V = sc.nextInt(); // 가중치

                A[S].add(new Edge(E, V));
            }
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<Integer>(); // BFS는 Queue로 구현 -> FIFO

        queue.add(v); // 처음에 들어온 노드 삽입
        visited[v] = true; // 해당 노드는 방문하였으므로 true

        while (!queue.isEmpty()) { // 큐가 비어있지않으면 반복
            int now = queue.poll(); // 하나 꺼내어

            for (Edge i : A[now]) { // 현재 노드에서 인접 노드 탐색
                int e = i.e;
                int w = i.w;

                if (!visited[e]) { // 인접 노드가 방문하지않은 배열이면
                    visited[e] = true; // true로
                    queue.add(e); // 큐에 삽입
                    distance[e] = distance[now] + w; // 핵심 => 거리 갱신
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS(1); // BFS

        int max = 1; // 1 부터 시작 -> 가장 긴 지름 찾으면 다시 BFS

        for (int i = 2; i <= N; i++) // 2 부터 N 까지
            if (distance[max] < distance[i]) // 가장 긴 지름에 해당하는 index 찾아서
                max = i; // max로 설정

        distance = new int[N + 1]; // 새로 초기화
        visited = new boolean[N + 1];

        BFS(max); // 가장 긴 index로 BFS 다시

        Arrays.sort(distance); // 오름차순 정렬

        System.out.println(distance[N]); // 가장 끝 index => 가장 긴 지름 출력
    }
}