import java.util.*;

/*
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
 */

public class 타임머신_백준 {
    static int N, M, INF;   // 크기, 최대값
    static List<Edge> A;    // 엣지리스트
    static long[] D;        // 거리배열

    static class Edge { // 엣지 클래스
        int s, e, w;

        public Edge(int s, int e, int w) {  // 생성자
            this.s = s; // 시작
            this.e = e; // 도착
            this.w = w; // 가중치
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 엣지
        INF = (N - 1) * 10000 + 1;  // 최대값, (노드 개수 - 1) * 최대 가중치 + 1 => 엣지 사용: N - 1

        // 초기화
        D = new long[N + 1];
        for(int i = 1; i <= N; i++)
            D[i] = INF;

        // 엣지리스트 구현
        A = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            A.add(new Edge(s, e, w));   // 저장
        }
    }

    public static void BellmanFord() {  // 벨만포드

        D[1] = 0;   // 시작노드인 1번노드는 거리 0으로 초기화

        for(int i = 1; i < N; i++) {    // 엣지 N - 1개 사용
            for(int j = 0; j < M; j++) {    // 모든 엣지에 대해
                Edge now = A.get(j);    // 엣지리스트 전부 순회

                if(D[now.s] == INF) // 도달하지 못하면 건너뛰기
                    continue;

                if(D[now.e] > D[now.s] + now.w) // 최단경로이면
                    D[now.e] = D[now.s] + now.w;    // 갱신
            }
        }
    }

    public static void printIsMinusCycle() {    // 음수싸이클이 있는지

        boolean minusCycle = false; // 음수싸이클 유무

        for(int i = 0; i < M; i++) {    // N - 1번 수행 후
                                        // 한 번 더 수행해서 최단경로가 있으면 음수싸이클 존재
            Edge now = A.get(i);    // 엣지리스트 전부 순회

            if(D[now.s] == INF) // 도달하지 못하면 건너뛰기
                continue;

            if(D[now.e] > D[now.s] + now.w) {   // 최단경로이면
                minusCycle = true;  // 음수싸이클 존재

                break;  // for 탈출
            }
        }

        if(!minusCycle) {   // 음수싸이클이 아니면
            for(int i = 2; i <= N; i++) {   // 시작 1번노드를 제외한 노드 전부 순회
                if(D[i] == INF) // 도달하지 못한 노드이면
                    System.out.println(-1); // -1 출력
                else    // 도달가능하면
                    System.out.println(D[i]);   // 값 출력
            }
        } else  // 음수싸이클이면
            System.out.println(-1); // -1 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BellmanFord();  // 벨만포드

        printIsMinusCycle();    // 음수싸이클 체크
    }
}
