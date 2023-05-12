import java.util.*;

/*
12
1 2 3
1 3 2
2 4 5
3 5 11
3 6 9
4 7 1
4 8 7
5 9 15
5 10 4
6 11 6
6 12 10
 */

public class 트리의지름_백준 {
    static int N, leafNode, D;  // 크기, 리프노드, 최대 지름
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열

    static class Node { // 노드 클래스
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        D = 0;  // 지름
        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            int W = sc.nextInt();

            A[S].add(new Node(E, W));
            A[E].add(new Node(S, W));
        }
    }

    public static void DFS(int v, int w) {  // DFS

        if(D < w) { // 최대 지름인 노드 찾기
            D = w;
            leafNode = v;
        }

        visited[v] = true;

        for(Node next : A[v])
            if(!visited[next.v])
                DFS(next.v, next.w + w);
    }

    public static void main(String[] args) {

        init(); // 초기화

        if(N > 1) { // 노드가 1개 초과이면, 1개 이면 엣지가 없으므로 그냥 0 출력
            visited = new boolean[N + 1];
            DFS(1, 0);

            visited = new boolean[N + 1];
            DFS(leafNode, 0);
        }

        System.out.println(D);  // 최대 지름 출력
    }
}
