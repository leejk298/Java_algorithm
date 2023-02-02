import java.util.*;
import java.io.*;

public class 최소공통조상1_LCA_074 {
    static ArrayList<Integer>[] tree; // 트리
    static int depth[]; // 깊이
    static int parent[]; // 부모노드
    static boolean visited[]; // 방문배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수

        tree = new ArrayList[N + 1]; // 트리 초기화
        for (int i = 1; i <= N; i++) // 노드 개수만큼
            tree[i] = new ArrayList<>(); // 트리 인접리스트 구현

        for (int i = 0; i < N - 1; i++) { // N - 1 개만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝

            tree[S].add(E); // 방향성 X => 양방향
            tree[E].add(S); // 트리 그래프처럼 표현 가능
        }

        depth = new int[N + 1]; // 초기화, 크기: N + 1 => 노드 1번부터 시작하므로
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1); // 루트노드인 1번부터 깊이, 부모노드 저장하기 위해 BFS, DFS 수행

        int M = Integer.parseInt(bf.readLine()); // 질의 개수
        for (int i = 0; i < M; i++) { // 질의 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int a = Integer.parseInt(st.nextToken()); // 숫자 1
            int b = Integer.parseInt(st.nextToken()); // 숫자 2
            int LCA = excuteLCA(a, b); // LCA 함수호출

            System.out.println(LCA); // 값 출력
        }
    }

    private static int excuteLCA(int a, int b) { // LCA: 깊이 -> 부모
        if (depth[a] < depth[b]) { // 깊이 다르면 큰 쪽을 앞으로 보냄
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (depth[a] != depth[b]) // 깊이 맞추기 위해 부모노드로 이동
            a = parent[a];

        while (a != b) { // 깊이가 같아지면 처음 만나는 부모노드 찾기
            a = parent[a];
            b = parent[b];
        }

        return a; // LCA 리턴
    }

    private static void BFS(int v) { // BFS
        Queue<Integer> queue = new LinkedList<>(); // 큐

        queue.add(v); // 루트 노드 삽입
        visited[v] = true; // 루트 노드 방문배열 갱신

        int d = 1, size = 1, cnt = 0; // 깊이(d), 해당깊이의 노드 개수(size)
        while (!queue.isEmpty()) { // 큐가 비어있지않으면 반복
            int nowNode = queue.poll(); // 하나 꺼내어

            for (int next : tree[nowNode]) { // 해당 노드의 인접리스트 탐색
                if (!visited[next]) { // 인접리스트가 방문하지 않았으면
                    visited[next] = true; // 방문배열 갱신
                    queue.add(next); // 큐에 삽입
                    parent[next] = nowNode; // 인접리스트의 부모노드를 해당 노드로 저장
                    depth[next] = d; // 깊이 저장
                }
            }

            cnt++; // 각 깊이가 끝날 때마다 노드의 개수 체크하기 위헤
            if (cnt == size) { // 같으면
                cnt = 0; // cnt 초기화
                size = queue.size(); // 다음 깊이의 노드 개수로 초기화
                d++; // 깊이 갱신
            }
        }
    }
}
