import java.util.*;

/*
3 3
1 2 2
3 1 3
2 3 2
1 3
 */

public class 중량제한_백준 {
    static int N, M;    // 크기
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열
    static int start, end;  // 시작, 끝점
    static int S, E;    // 이분 탐색 인덱스

    static class Node { // 노드 클래스
        int v, w;   // 매개변수

        public Node(int v, int w) { // 파라미터 생성자
            this.v = v;
            this.w = w;
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드 개수
        M = sc.nextInt();   // 엣지 개수

        // 초기화
        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        S = Integer.MAX_VALUE;  // 시작 인덱스: 최소값 구해야하므로 최대값으로 초기화
        E = Integer.MIN_VALUE;  // 끝 인덱스: 최대값

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            A[s].add(new Node(e, w));   // 양방향
            A[e].add(new Node(s, w));

            S = Math.min(S, w); // 최소
            E = Math.max(E, w); // 최대
        }

        start = sc.nextInt();   // 시작점
        end = sc.nextInt();     // 도착점
    }

    public static boolean BFS(int weight) { // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐
        visited = new boolean[N + 1];   // 방문배열 초기화

        queue.offer(new Node(start, 0));    // 큐에 시작점 삽입
        visited[start] = true;  // 시작점 방문 여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            if(now.v == end)    // 끝 점이면
                return true;    // 도달했으므로 true 리턴

            for(int i = 0; i < A[now.v].size(); i++) {  // 인접 노드 개수만큼
                Node next = A[now.v].get(i);    // 다음 노드

                if(weight <= next.w && !visited[next.v]) {  // 최대 무게보다 크고 방문하지 않은 노드인 경우
                    visited[next.v] = true; // 방문 여부 갱신
                    queue.offer(new Node(next.v, next.w));  // 큐에 삽입
                }
            }
        }

        return false;   // 도달 불가하므로 false 리턴
    }

    public static void BinarySearch() { // 이분 탐색

        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(BFS(mid)) {  // BFS, 해당 무게가 가능하면
                S = mid + 1;    // 더 큰 무게로
                res = mid;  // 가능했으므로 결과값 저장
            } else  // 불가능하면
                E = mid - 1;    // 더 작은 무게로
        }

        System.out.println(res);    // 결과값 출력
    }


    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
