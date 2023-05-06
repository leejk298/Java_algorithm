import java.util.*;

/*
4 2
2 1 2
4 3 2
1 4 3
1 2
3 2
 */

public class 노드사이의거리_백준 {
    static int N, M;    // 크기
    static List<Node> A[];  // 인접리스트
    static boolean[] visited;   // 방문배열
    static List<int[]> list;    // 좌표리스트

    static class Node { // 노드 클래스
        int v, w;   // 정점, 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드 개수
        M = sc.nextInt();   // 테스트 개수

        // 인접리스트 구현
        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for(int i = 1; i < N; i++) {    // N - 1 만큼
            int S = sc.nextInt();   // 시작
            int E = sc.nextInt();   // 끝
            int W = sc.nextInt();   // 가중치

            A[S].add(new Node(E, W));   // 인접리스트 저장
            A[E].add(new Node(S, W));
        }

        // 좌표
        list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();

            list.add(new int[] {S, E});
        }
    }

    public static int BFS(int S, int E) {   // BFS
        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(S, 0));    // 시작점 삽입
        visited[S] = true;  // 방문여부 갱신
        int D = 0;  // 거리

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            if(now.v == E) {    // 도착하면
                D = now.w;  // 거리 저장

                break;  // while 종료
            }

            for(Node next : A[now.v]) { // 인접리스트
                if(!visited[next.v]) {  // 방문하지 않았으면
                    visited[next.v] = true; // 방문여부 갱신
                    queue.offer(new Node(next.v, now.w + next.w));  // 큐에 삽입
                }
            }
        }

        return D;   // 거리 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        for(int i = 0; i < M; i++) {    // M 만큼
            int[] arr = list.get(i);    // 좌표리스트

            int S = arr[0], E = arr[1]; // 좌표
            visited = new boolean[N + 1];   // 방문배열 초기화

            System.out.println(BFS(S, E));  // BFS, 노드간 거리 출력
        }
    }
}
