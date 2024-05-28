import java.io.*;
import java.util.*;

public class 친구관계파악_DFS_025 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static boolean arrive; // 도착 여부

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 엣지

        visited = new boolean[N]; // 방문배열
        A = new ArrayList[N]; // 노드

        for (int i = 0; i < N; i++) // 노드 개수만큼
            A[i] = new ArrayList<Integer>(); // 연결리스트로 인접리스트 구현

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작점
            int E = Integer.parseInt(st.nextToken()); // 끝점

            A[S].add(E); // 무방향
            A[E].add(S);
        }
    }

    public static void DFS(int v, int depth) {   // 브루트포스, DFS

        if (depth == 5) { // 베이스케이스: 깊이가 5이면 도착한 것이므로
            arrive = true; // 도착 여부 true

            return; // 함수 종료
        }

        // 재귀케이스: 깊이가 5가 아니고 도착이 없으면
        visited[v] = true; // 해당 노드 방문 true로 설정

        for (int i : A[v]) // 해당 노드를 순회하면서
            if (!visited[i]) // 방문 안한 노드가 있으면
                DFS(i, depth + 1); // 해당 노드로 DFS 재귀호출

        visited[v] = false; // 리턴되면 다시 해당 노드의 방문여부 false로 설정
    }

    public static void printResult() {  // 결과 출력

        for (int i = 0; i < N; i++) { // 노드 개수만큼
            DFS(i, 1); // DFS 수행

            if (arrive) // 도착이 있으면
                break; // 반복문 종료
            // 없으면 다음 노드로
        }

        if (arrive) // 도착이 있으면
            System.out.println("1"); // 1 출력
        else // 없으면
            System.out.println("0"); // 0 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printResult();  // 결과 출력
    }
}