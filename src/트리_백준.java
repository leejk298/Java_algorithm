import java.util.*;

/*
5
-1 0 0 1 1
1
 */

public class 트리_백준 {
    static int N, root; // 크기, 루트노드
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int leafNodeCount;   // 리프노드 개수
    static int deleteNode;  // 삭제할 노드

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 개수

        // 초기화
        A = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < N; i++) {    // 개수만큼
            int parent = sc.nextInt();  // 부모노드

            if(parent == -1)    // -1 이면 루트노드
                root = i;
            else {  // 아니면
                A[parent].add(i);   // 무방향, 트리도 그래프처럼 표현
                A[i].add(parent);
            }
        }

        deleteNode = sc.nextInt();  // 삭제할 노드
    }

    public static void DFS(int v) { // DFS

        visited[v] = true;  // 방문여부 갱신

        int count = 0;  // 자식노드 개수
        for(int next : A[v]) {  // 인접리스트 순회
            if(!visited[next] && next != deleteNode) {  // 방문하지 않았고 삭제할 노드가 아니면
                count++;    // 개수 카운트
                DFS(next);  // DFS
            }
        }

        if(count == 0)  // 자식노드가 없으면
            leafNodeCount++;    // 리프노드 개수 카운트
    }

    public static void main(String[] args) {

        init(); // 초기화

        if(deleteNode == root)  // 루트인 경우
            System.out.println(0);  // 0
        else {  // 루트가 아니면
            DFS(root);  // 루트노드로 DFS 수행
            System.out.println(leafNodeCount);  // 리프노드 개수 카운트
        }
    }
}
