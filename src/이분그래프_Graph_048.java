import java.util.*;
import java.io.*;

public class 이분그래프_Graph_048 {
    static boolean isEven; // 이분그래프 판별

    public static void DFS(int v, ArrayList<Integer>[] A, boolean[] visited, int[] check) { // DFS

        visited[v] = true; // 들어온 노드의 방문정보 갱신

        for (int i : A[v]) { // 해당 노드의 인접리스트 탐색
            if (!visited[i]) { // 인접리스트 중 방문하지않은 노드가 있으면
                check[i] = (check[v] + 1) % 2; // 원래 노드와 인접 노드를 서로 다른 집합으로

                DFS(i, A, visited, check); // 인접 노드에 대해 DFS - 재귀
            }

            else if (check[i] == check[v]) // 이미 방문한 배열이면 같은 집합인 지 체크
                isEven = false; // 같은 집합이면 이분그래프 x
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int testCase = Integer.parseInt(st.nextToken()); // 테스트케이스 개수

        for (int t = 0; t < testCase; t++) { // 테스트케이스 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int N = Integer.parseInt(st.nextToken()); // 노드
            int M = Integer.parseInt(st.nextToken()); // 엣지

            boolean visited[] = new boolean[N + 1]; // 방문배열
            ArrayList<Integer>[] A = new ArrayList[N + 1]; // 인접리스트
            int check[] = new int[N + 1]; // 체크배열
            isEven = true; // 초기화

            for (int i = 1; i <= N; i++) // 노드 개수만큼
                A[i] = new ArrayList<Integer>(); // 인접리스트 구현

            for (int i = 0; i < M; i++) { // 엣지 개수만큼
                st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

                int S = Integer.parseInt(st.nextToken()); // 시작
                int E = Integer.parseInt(st.nextToken()); // 끝

                A[S].add(E); // 방향성 x
                A[E].add(S);
            }

            for (int i = 1; i <= N; i++) { // 모든 노드에 대해 => 하나의 연결요소인지 모르기때문에
                if (isEven) // 이분 그래프이면
                    DFS(i, A, visited, check); // DFS 실행

                else { // 아니면
                    System.out.println("NO"); // NO 출력 후 종료
                    break;
                }
            }

            if (isEven) // 모든 노드 탐색 후 이분 그래프이면
                System.out.println("YES"); // YES 출력
        }
    }
}
