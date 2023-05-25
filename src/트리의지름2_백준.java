import java.util.*;

/*
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
 */

public class 트리의지름2_백준 {
    static int N, maxNode, maxD;    // 크기, 최대값을 가지는 노드
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열

    static class Node { // 노드 클래스
        int v, w;

        public Node(int v, int w) { // 생성자
            this.v = v; // 정점
            this.w = w; // 가중치
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        maxD = 0;   // 최대거리

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < N; i++) {    // 정점 개수만큼
            int s = sc.nextInt();   // 시작점

            while(true) {
                int e = sc.nextInt();   // 도착점

                if(e == -1) // -1이 이면 while 종료
                    break;

                int w = sc.nextInt();   // 가중치

                A[s].add(new Node(e, w));   // 인접리스트 저장
            }
        }
    }

    public static void DFS(int v, int d) {  // DFS

        if(visited[v])  // 베이스케이스
            return;

        // 재귀케이스
        visited[v] = true;  // 방문여부 갱신

        if(d > maxD) {  // 최대거리 갱신
            maxD = d;
            maxNode = v;    // 최대거리를 가지는 노드 저장
        }

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 순회
            Node next = A[v].get(i);    // 다음 노드

            if(!visited[next.v])    // 해당 정점을 방문한 적이 없으면
                DFS(next.v, next.w + d);    // DFS, 거리 갱신
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(1, 0);  // 우선 1번노드로 DFS 수행, 최대거리를 갖는 노드 찾기

        // 초기화
        visited = new boolean[N + 1];
        maxD = 0;

        DFS(maxNode, 0);    // 최대거리를 갖는 노드로 DFS 수행, 최대거리 찾기

        System.out.println(maxD);   // 최대거리 출력
    }
}
