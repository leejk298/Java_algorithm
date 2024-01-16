import java.util.*;
import java.io.*;

public class 타임머신_벨만포드_059 {
    static int N, M;
    static vEdge[] edges;
    static long[] D;

    static class vEdge { // 엣지 클래스
        int S, E, W; // 멤버 변수

        // 멤버 함수
        public vEdge(int S, int E, int W) { // 파라미터 생성자
            this.S = S;
            this.E = E;
            this.W = W;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 엣지

        edges = new vEdge[M]; // 벨만포드 => 엣지리스트 필요, 크기: 엣지 개수
        D = new long[N + 1]; // 최단경로 배열, 크기: 노드 개수

        for (int i = 0; i <= N; i++) // 노드 개수만큼
            D[i] = Integer.MAX_VALUE; // 최단경로 무한대로 초기화

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            edges[i] = new vEdge(S, E, W); // 엣지리스트 저장
        }
    }

    public static void BellmanFord() {  // 벨만포드

        D[1] = 0; // 시작노드 최단경로값 0으로 설정

        for (int i = 1; i < N; i++) { // N-1 번 실행 => 최단경로
            for (int j = 0; j < M; j++) { // 엣지 개수만큼
                vEdge now = edges[j]; // 엣지 정보 하나 꺼내어

                if (D[now.S] != Integer.MAX_VALUE && D[now.E] > D[now.S] + now.W) // 최단경로값이 무한대가 아니고 업데이트가 필요하면
                    D[now.E] = D[now.S] + now.W; // 업데이트
            }
        }

        boolean minusCycle = false; // 음수사이클 여부
        for (int i = 0; i < M; i++) { // 한 번 더 실행 => 업데이트가 되면 음수사이클 존재 O
            vEdge now = edges[i];

            if (D[now.S] != Integer.MAX_VALUE && D[now.E] > D[now.S] + now.W) // 최단경로값이 무한대가 아니고 업데이트가 필요하면
                minusCycle = true; // 음수사이클 존재
        }

        if (!minusCycle) { // 음수사이클이 없으면
            for (int i = 2; i <= N; i++) { // 시작 노드 제외한 모든 노드
                if (D[i] == Integer.MAX_VALUE) // 해당 노드의 최단경로값이 무한대이면 -1 출력
                    System.out.println("-1");
                else // 무한대가 아니면 해당 노드의 최단경로값 출력
                    System.out.println(D[i]);
            }
        }

        else // 음수사이클이 있으면
            System.out.println("-1"); // -1 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BellmanFord();  // 벨만포드
    }
}