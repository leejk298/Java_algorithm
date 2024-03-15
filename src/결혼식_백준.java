import java.io.*;
import java.util.*;

/*
6
5
1 2
1 3
3 4
2 3
4 5
 */

public class 결혼식_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        A = new ArrayList[N + 1];   // 인접리스트
        visited = new boolean[N + 1];   // 방문배열

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작
            int e = Integer.parseInt(st.nextToken());   // 도착

            A[s].add(e);    // 양방향
            A[e].add(s);
        }
    }

    public static void DFS(int v, int depth) {  // DFS

        visited[v] = true;  // 방문여부 갱신

        if (depth == 2)  // 친구의 친구까지
            return;

        for (int next : A[v])   // 인접리스트 순회
            if (!visited[next]) // 방문한 적이 없으면
                DFS(next, depth + 1);   // DFS
    }

    public static void printIsInvite() {    // 초대가능한 친구

        int count = 0;  // 개수

        for (int i = 2; i <= N; i++) // 2번부터
            if (visited[i])  // 방문했으면
                count++;    // 개수 카운트

        System.out.println(count);  // 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(1, 0);  // DFS, 1번 노드

        printIsInvite();    // 출력
    }
}
