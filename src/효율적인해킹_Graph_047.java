import java.util.*;
import java.io.*;

public class 효율적인해킹_Graph_047 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] res;

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 에지

        A = new ArrayList[N + 1]; // 인접리스트
        res = new int[N + 1]; // 결과배열

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            A[i] = new ArrayList<Integer>(); // 인접리스트 구현

        for (int i = 0; i < M; i++) { // 에지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝

            A[S].add(E); // 인접리스트 추가
        }
    }

    public static void BFS(int v, boolean[] visited, ArrayList<Integer>[] A, int[] res) { // BFS

        Queue<Integer> queue = new LinkedList<Integer>(); // 큐 구현

        queue.add(v); // 큐에 추가
        visited[v] = true; // 방문배열 갱신

        while (!queue.isEmpty()) { // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for (int i : A[now]) { // 해당 노드를 탐색
                if (!visited[i]) { // 해당 노드의 인접리스트 중에 방문하지않은 노드가 있으면
                    visited[i] = true; // 해당 노드의 방문배열 갱신
                    res[i]++; // 결과 갱신

                    queue.add(i); // 큐에 추가
                }
            }
        }
    }

    public static void printMaxCount() {    // 최대 개수 출력
        int maxVal = 0; // 최대값

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            maxVal = Math.max(maxVal, res[i]); // 최대값 찾아서

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            if (res[i] == maxVal) // 최대값을 가진 노드이면
                System.out.print(i + " "); // 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            visited = new boolean[N + 1]; // 방문배열 초기화
            BFS(i, visited, A, res); // BFS
        }

        printMaxCount();    // 최대 개수 출력
    }
}