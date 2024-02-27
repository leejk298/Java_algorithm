import java.util.*;
import java.io.*;

/*
5 4
3 1
3 2
4 3
5 3
 */

public class 효율적인해킹_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 결과배열
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        arr = new int[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작
            int e = Integer.parseInt(st.nextToken());   // 도착

            A[s].add(e);    // 단방향
        }
    }

    public static void BFS(int v) { // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(v); // 시작점 큐에 삽입
        visited[v] = true;  // 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for (int next : A[now]) {   // 해당 정점의 인접리스트 순회
                if (!visited[next]) {   // 다음 정점을 방문한 적이 없으면
                    visited[next] = true;   // 방문
                    arr[next]++;    // 카운트
                    queue.offer(next);  // 큐에 삽입
                }
            }
        }
    }

    public static void findMaxCount() { // 최대 개수 찾기

        for (int i = 1; i <= N; i++) {  // 정점 개수만큼
            visited = new boolean[N + 1];   // 방문배열 초기화
            BFS(i); // BFS
        }

        int max = 0;    // 최대값
        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            max = Math.max(max, arr[i]);    // 최대값 찾기

        StringBuilder sb = new StringBuilder(); // 결과 문자열
        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            if (max == arr[i])  // 최대값과 같으면
                sb.append(i + " "); // 문자열에 추가

        System.out.println(sb); // 결과 문자열 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findMaxCount(); // 가장 많은 컴퓨터를 해킹할 수 있는 번호
    }
}
