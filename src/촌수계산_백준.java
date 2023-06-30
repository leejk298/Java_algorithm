import java.util.*;
import java.io.*;

/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */

public class 촌수계산_백준 {
    static int N, S, E, M, res; // 크기, 시작, 끝, 결과값
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;  // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 정점 개수
        res = -1;   // 결과값, 도달하지 못하면 -1 출력

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        S = Integer.parseInt(st.nextToken());   // 시작
        E = Integer.parseInt(st.nextToken());   // 도착

        M = Integer.parseInt(bf.readLine());    // 엣지 개수
        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int start = Integer.parseInt(st.nextToken());   // 시작
            int end = Integer.parseInt(st.nextToken());     // 도착

            A[start].add(end);  // 양방향
            A[end].add(start);
        }
    }

    public static void DFS(int depth, int v) {  // DFS

        if(visited[v])  // 방문한 적이 있으면
            return; // 리턴

        // 없으면
        visited[v] = true;  // 방문

        if(v == E) {    // 도착점 도달하면
            res = depth;    // 몇 촌인지 저장

            return; // 리턴
        }

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 개수만큼
            int next = A[v].get(i); // 다음 노드

            if(!visited[next])  // 방문한 적이 없으면
                DFS(depth + 1, next);   // DFS
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, S);  // DFS

        System.out.println(res);    // 결과값 출력
    }
}
