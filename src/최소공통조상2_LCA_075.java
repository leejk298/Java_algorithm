import java.util.*;
import java.io.*;

public class 최소공통조상2_LCA_075 {
    static ArrayList<Integer>[] tree; // 트리
    static int depth[]; // 깊이
    static int parent[][]; // 부모노드
    static boolean visited[]; // 방문배열
    static int maxD; // 최대깊이

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수

        tree = new ArrayList[N + 1]; // 트리 초기화
        for (int i = 1; i <= N; i++) // 트리
            tree[i] = new ArrayList<>(); // 인접리스트 저장

        for (int i = 0; i < N - 1; i++) { // N - 1 개만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝

            tree[S].add(E); // 방향성 X
            tree[E].add(S); // 양방향
        }

        depth = new int[N + 1]; // 초기화, 크기: N + 1 => 1번 노드부터 시작
        visited = new boolean[N + 1];
        maxD = 0;

        int tmp = 1;
        while (tmp <= N) { // 최대 깊이 찾기
            tmp *= 2;
            maxD++;
        }

        parent = new int[maxD + 1][N + 1]; // 부모노드 초기화

        BFS(1); // BFS로 깊이, 부모노드 찾기

        for (int k = 1; k <= maxD; k++) // k
            for (int n = 1; n <= N; n++) // n
                parent[k][n] = parent[k - 1][parent[k - 1][n]]; // LCA 빠르게 찾기 점화식

        int M = Integer.parseInt(bf.readLine()); // 질의 개수
        for (int i = 0; i < M; i++) { // 질의 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한줄 스트링

            int a = Integer.parseInt(st.nextToken()); // 숫자 1
            int b = Integer.parseInt(st.nextToken()); // 숫자 2
            int LCA = excuteLCA(a, b); // LCA 함수호출

            System.out.println(LCA); // 값 출력
        }
    }

    private static int excuteLCA(int a, int b) { // LCA
        if (depth[a] > depth[b]) { // 깊이 큰 게 b로 오게
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int k = maxD; k >= 0; k--) // 최대 깊이만큼
            if (Math.pow(2, k) <= depth[b] - depth[a]) // 해당하는 깊이로 가서
                if (depth[a] <= depth[parent[k][b]]) // 깊이 맞춰줌
                    b = parent[k][b];

        for (int k = maxD; k >= 0; k--) { // 최대 깊이만큼
            if (parent[k][a] != parent[k][b]) { // 최소 공통 조상이 같게 맞춰줌
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int LCA = a;
        if (a != b) // 다르면 위에서 0까지 반복이 끝난 상태이므로
            LCA = parent[0][LCA]; // 바로 위 노드가 최소공통조상이 됨

        // 같으면 그대로 리턴
        return LCA;
    }

    private static void BFS(int v) { // BFS
        Queue<Integer> queue = new LinkedList<>(); // 큐

        queue.add(v); // 루트노드 삽입
        visited[v] = true; // 루트노드 방문배열 갱신
        int d = 1, size = 1, cnt = 0; // 깊이(d), 인접리스트 개수(size)

        while (!queue.isEmpty()) { // 큐가 비어있지않으면 반복
            int nowNode = queue.poll(); // 하나 꺼내어

            for (int next : tree[nowNode]) { // 해당 노드의 인접리스트 탐색
                if (!visited[next]) { // 인접리스트가 방문하지않았으면
                    visited[next] = true; // 방문배열 갱신
                    queue.add(next); // 큐에 삽입
                    parent[0][next] = nowNode; // 해당 부모노드 저장
                    depth[next] = d; // 깊이 저장
                }
            }

            cnt++; // 큐에 사이즈와 인접리스트 개수가 같은지 체크하기 위해
            if (cnt == size) { // 같으면
                cnt = 0; // 개수 초기화
                size = queue.size(); // 다음 깊이의 인접리스트 크기로 초기화
                d++; // 다음 깊이로
            }
        }
    }
}
