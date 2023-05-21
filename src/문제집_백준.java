import java.util.*;

/*
4 2
4 2
3 1
 */

public class 문제집_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static int[] in;    // 진입차수

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        in = new int[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 인접리스트 저장
            in[e]++;    // 진입차수
        }
    }

    public static void printTopologicalSort() { // 위상정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐, 난이도 낮은 것부터 해야하므로 정점 번호가 낮은 것부터

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            if(in[i] == 0)  // 진입차수가 0이면
                pq.offer(i);    // 우선순위 큐에 삽입

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            int now = pq.poll();    // 하나 꺼내어

            System.out.print(now + " ");    // 출력

            for(int i = 0; i < A[now].size(); i++) {    // 인접리스트 순회
                int next = A[now].get(i);   // 다음 정점
                in[next]--; // 진입차수 갱신

                if(in[next] == 0)   // 0이면
                    pq.offer(next); // 우선순위 큐에 삽입
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printTopologicalSort(); // 위상정렬 출력
    }
}
