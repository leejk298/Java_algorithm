import java.util.*;
import java.io.*;

/*
4 2
4 2
3 1
 */

public class 줄세우기_위상정렬_053 {
    static int N, M;    // 크기
    static ArrayList<Integer>[] A;  // 인접리스트
    static int[] inDegree;  // 진입차수

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            A[S].add(E);    // 방향 그래프
            inDegree[E]++;  // 진입차수 저장
        }
    }

    public static void TopologicalSort() {  // 위상정렬

        Queue<Integer> queue = new LinkedList<>();  // 큐

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            if(inDegree[i] == 0)   // 진입차수가 0이면
                queue.offer(i);     // 큐에 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어 => 진입차수가 작은 것부터 정렬됨

            System.out.print(now + " ");    // 출력

            for(int i = 0; i < A[now].size(); i++) {    // 인접리스트 크기만큼
                int next = A[now].get(i);   // 다음 정점

                inDegree[next]--;   // 진입차수 하나 줄임
                if(inDegree[next] == 0) // 0이 되면
                    queue.offer(next);  // 큐에 삽입
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        TopologicalSort();  // 위상정렬
    }
}
