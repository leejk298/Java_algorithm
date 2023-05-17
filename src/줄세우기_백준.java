import java.util.*;

/*
4 2
4 2
3 1
 */

public class 줄세우기_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static int[] in;    // 진입차수

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        in = new int[N + 1];

        for (int i = 1; i <= N; i++)    // 인접리스트 구현
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 인접리스트 저장
            in[e]++;        // 끝점에 진입차수 증가
        }
    }

    public static void printTopologicalSort() { // 위상정렬 - DAG, 진입차수 이용

        Queue<Integer> queue = new LinkedList<>();  // 큐

        for (int i = 1; i <= N; i++)    // 노드 개수만큼
            if (in[i] == 0) // 진입차수 0이면
                queue.offer(i); // 큐에 삽입

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어
            System.out.print(now + " ");    // 출력

            for (int next : A[now]) {   // 인접리스트 순회
                in[next]--; // 진입차수 감소

                if (in[next] == 0)  // 0이면
                    queue.offer(next);  // 큐에 삽입
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printTopologicalSort(); // 위상정렬 출력
    }
}
