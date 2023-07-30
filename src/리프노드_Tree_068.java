import java.util.*;

public class 리프노드_Tree_068 {
    static ArrayList<Integer>[] tree; // 트리
    static boolean visited[]; // 방문배열
    static int N, count, root; // 리프노드 개수
    static int deleteNode = 0; // 삭제할 노드

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in); // 입력

        N = sc.nextInt(); // 노드 개수
        count = 0;

        tree = new ArrayList[N]; // 초기화, 0번부터 시작 => 크기: N
        visited = new boolean[N];

        root = 0; // 루트노드
        for (int i = 0; i < N; i++) // 노드 개수만큼
            tree[i] = new ArrayList<>(); // 트리 구현

        for (int i = 0; i < N; i++) { // 노드 개수만큼
            int t = sc.nextInt(); // 입력

            if (t != -1) { // 루트노드가 아니면
                tree[i].add(t); // 양방향 => 트리를 그래프처럼 표현
                tree[t].add(i);
            } else // 루트노드이면
                root = i; // 해당노드 저장
        }

        deleteNode = sc.nextInt(); // 삭제할 노드
    }

    public static void DFS(int v) { // DFS

        visited[v] = true; // 방문배열 갱신

        int cNode = 0; // 자식노드 개수
        for (int i : tree[v]) { // 해당노드의 인접노드(=자식노드) 탐색
            if (!visited[i] && i != deleteNode) { // 방문하지않았고 삭제할 노드가 아니면
                cNode++; // 해당노드의 자식노드 개수 카운트
                DFS(i); // 자식노드로 DFS 수행
            }
        }

        if (cNode == 0) // 해당노드의 자식노드가 없으면 => 리프노드
            count++; // 리프노드 개수 카운트
    }

    public static void printCount() {   // 리프노드 개수 출력

        if (deleteNode == root) // 삭제할 노드가 루트노드이면
            System.out.println(0); // 0 출력 => 리프노드가 없으므로

        else { // 루트노드가 아니면
            DFS(root); // 루트노드로 DFS 수행
            System.out.println(count); // 리프노드 개수 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printCount();   // 리프노드 개수 출력
    }
}
