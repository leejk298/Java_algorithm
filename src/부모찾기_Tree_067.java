import java.util.*;

public class 부모찾기_Tree_067 {
    static int N; // 노드
    static ArrayList<Integer>[] tree; // 트리
    static boolean visited[]; // 방문배열
    static int res[]; // 부모배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        N = sc.nextInt(); // 노드 개수

        visited = new boolean[N + 1]; // 초기화, 노드 1부터 시작 => 크기: N + 1
        tree = new ArrayList[N + 1];
        res = new int[N + 1];

        for (int i = 0; i <= N; i++) // N + 1개 만큼
            tree[i] = new ArrayList<>(); // 트리 초기화

        for (int i = 1; i < N; i++) { // N - 1개 만큼
            int a = sc.nextInt(); // 숫자 1
            int b = sc.nextInt(); // 숫자 2

            tree[a].add(b); // 양방향 => 트리를 그래프처럼 표현가능
            tree[b].add(a);
        }

        DFS(1); // 루트노드인 1번 노드부터 DFS 수행

        for (int i = 2; i <= N; i++) // 노드 2번부터 해당노드의 부모노드 출력
            System.out.println(res[i]);
    }

    private static void DFS(int v) { // DFS
        visited[v] = true; // 방문배열 갱신

        for (int i : tree[v]) { // 해당노드의 인접노드들을 탐색하여
            if (!visited[i]) { // 인접노드가 방문되지않았으면
                res[i] = v; // 인접노드(=자식노드)의 부모노드를 부모배열에 저장
                DFS(i); // 해당자식노드로 DFS 수행
            }
        }
    }
}
