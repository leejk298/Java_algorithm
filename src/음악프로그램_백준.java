import java.util.*;
import java.io.*;

/*
6 3
3 1 4 3
4 6 2 5 4
2 2 3
 */

public class 음악프로그램_백준 {
    static int N, M;    // 크기
    static int[] inDegree;  // 진입차수
    static List<Integer>[] A;   // 인접리스트
    static StringBuilder sb;    // 결과 문자열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        sb = new StringBuilder();
        inDegree = new int[N + 1];
        A = new List[N + 1];

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int K = Integer.parseInt(st.nextToken());   // 크기
            int[] arr = new int[K]; // 배열

            for (int j = 0; j < K; j++) // 크기만큼
                arr[j] = Integer.parseInt(st.nextToken());  // 배열 저장

            for (int j = 1; j < K; j++) {   // 크기 - 1 만큼
                int s = arr[j - 1]; // 시작
                int e = arr[j]; // 도착

                A[s].add(e);    // 단방향
                inDegree[e]++;  // 진입차수 갱신
            }
        }
    }

    public static void TopologicalSort() {  // 위상정렬

        Queue<Integer> queue = new LinkedList<>();  // 큐

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            if (inDegree[i] == 0)   // 진입차수가 0이면
                queue.offer(i); // 큐에 삽입

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            sb.append(now + "\n");  // 결과 문자열에 삽입

            for (int next : A[now]) {   // 인접리스트 순회
                inDegree[next]--;   // 진입차수 갱신

                if (inDegree[next] == 0)    // 0이면
                    queue.offer(next);  // 큐에 삽입
            }
        }
    }

    public static void printResult() {  // 결과 출력

        boolean flag = true;    // 순서 정하기

        for (int i = 1; i <= N; i++) {  // 정점 개수만큼
            if (inDegree[i] != 0) { // 0이 아니면
                flag = false;   // 순서를 정할 수 없으므로 false

                break;  // for-i 종료
            }
        }

        if (!flag)  // 순서를 정할 수 없으면
            System.out.println(0);  // 0
        else    // 있으면
            System.out.println(sb); // 결과 문자열 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        TopologicalSort();  // 위상정렬

        printResult();  // 결과 출력
    }
}
