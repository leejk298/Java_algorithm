import java.io.*;
import java.util.*;

public class DFS_BFS_026 {
    static ArrayList<Integer> A[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 엣지
        int start = Integer.parseInt(st.nextToken()); // 시작점

        A = new ArrayList[N + 1]; // 인접리스트
        for (int i = 1; i <= N; i++) { // 노드 개수만큼 구현
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
            int S = Integer.parseInt(st.nextToken()); // 출발
            int E = Integer.parseInt(st.nextToken()); // 종료

            A[S].add(E); // 양방향
            A[E].add(S);
        }

        visited = new boolean[N + 1]; // 방문배열 초기화
        DFS(start); // DFS
        System.out.println(); // 개행문자 출력

        visited = new boolean[N + 1]; // 방문배열 초기화
        BFS(start); // BFS
        System.out.println();
    }

    private static void DFS(int start) { // DFS
        System.out.print(start + " "); // 노드 출력

        visited[start] = true; // 방문배열 갱신
        for (int i : A[start]) { // 해당 노드의 인접리스트들 순회하면서
            if (!visited[i]) { // 인접리스트들이 방문되지 않았으면
                DFS(i); // DFS 실행
            }
        }
    }

    private static void BFS(int start) { // BFS
        Queue<Integer> queue = new LinkedList<>(); // 큐 구현
        queue.add(start); // 해당 노드 큐에 삽입
        visited[start] = true; // 방문배열 갱신

        while (!queue.isEmpty()) { // 비어있지않으면 반복
            int now = queue.poll(); // 하나 꺼내어
            System.out.print(now + " "); // 노드 출력
            for (int i : A[now]) { // 해당 노드의 인접리스트들 순회하면서
                if (!visited[i]) { // 인접리스트들이 방문되지 않았으면
                    visited[i] = true; // 방문배열 갱신
                    queue.add(i); // 큐에 삽입 => FIFO
                }
            }
        }

    }
}
