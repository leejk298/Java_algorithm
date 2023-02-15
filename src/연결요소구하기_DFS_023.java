import java.io.*;
import java.util.*;

public class 연결요소구하기_DFS_023 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 엣지

        ArrayList<Integer>[] A = new ArrayList[N + 1]; // 노드 리스트, 노드 1번부터 N까지
        boolean visited[] = new boolean[N + 1]; // 방문 배열

        for (int i = 1; i <= N; i++) // N 만큼
            A[i] = new ArrayList<Integer>(); // 해당 노드 리스트에 인접리스트 구현

        for (int i = 0; i < M; i++) { // M 만큼
            st = new StringTokenizer(bf.readLine());

            int S = Integer.parseInt(st.nextToken()); // 시작점
            int E = Integer.parseInt(st.nextToken()); // 끝점

            A[S].add(E); // 방향이 없으므로 양방향성
            A[E].add(S);
        }

        int cnt = 0; // DFS 호출 횟수 => 연결요소 갯수

        for (int i = 1; i <= N; i++) { // N 만큼
            if (!visited[i]) { // 방문안한 노드이면
                cnt++; // 횟수 증가

                DFS(A, visited, i); // DFS 호출
            }
        }

        System.out.println(cnt); // 출력
    }

    private static void DFS(ArrayList<Integer>[] A, boolean[] visited, int V) { // DFS: O(N + M) 성능
        if (visited[V]) // 방문한 노드이면 돌아감 -> 베이스케이스
            return;

        // 방문안한 노드이면
        visited[V] = true; // 방문했다고 설정

        for (int i : A[V]) // 해당노드의 인접리스트를 순회하면서
            if (!visited[i]) // 인접리스트가 방문안한 노드이면
                DFS(A, visited, i); // DFS 호출 -> 재귀함수 LIFO
    }
}