import java.util.*;
import java.io.*;

public class k번째최단경로_다익스트라_058 {
    static int N, M, K;
    static int[][] A;
    static PriorityQueue<Integer>[] D;
    static BufferedReader bf;
    static BufferedWriter bw;

    static class Node implements Comparable<Node> {	// Node 클래스 => Comparable 인터페이스 구현 => compareTo() 메소드재정의
        // 멤버 변수
        int node;
        int w;

        // 멤버 함수
        Node(int node, int w) {	// 파라미터 생성자
            this.node = node;
            this.w = w;
        }

        @Override   // 오버라이딩
        public int compareTo(Node V) {	// 정렬 기준
            return this.w - V.w;	// 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        bf = new BufferedReader(new InputStreamReader(System.in));	// 입력 버퍼
        bw = new BufferedWriter(new OutputStreamWriter(System.out));	// 출력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());	// 한 줄 스트링

        N = Integer.parseInt(st.nextToken());	// 노드
        M = Integer.parseInt(st.nextToken());	// 엣지
        K = Integer.parseInt(st.nextToken());	// K번째 최단경로

        A = new int[N + 1][N + 1];	// 인접행렬
        D = new PriorityQueue[N + 1];	// 최단경로 우선순위 큐 배열

        Comparator<Integer> cp = new Comparator<Integer>() {	// Comparator : 정렬 기준
            @Override
            public int compare(Integer o1, Integer o2) {	// compare() 메소드 재정의
                return o2 - o1;	// 내림차순 정렬 => o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i <= N; i++)	// 노드 개수만큼
            D[i] = new PriorityQueue<Integer>(K, cp);	// 최단경로 우선순위 큐 배열: 크기 K와 정렬기준을 가짐

        for (int i = 0; i < M; i++) {	// 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());	// 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());	// 시작
            int E = Integer.parseInt(st.nextToken());	// 끝
            int W = Integer.parseInt(st.nextToken());	// 가중치

            A[S][E] = W;	// 인접행렬
        }
    }

    public static void Dijkstra() throws IOException {

        PriorityQueue<Node> pq = new PriorityQueue<>();	// 우선순위 큐

        pq.add(new Node(1, 0));	// 출발노드 추가
        D[1].add(0);	// 최단경로 추가

        while (!pq.isEmpty()) {	// 큐가 비어있지 않으면
            Node u = pq.poll();	// 하나 꺼내어

            for (int i = 1; i <= N; i++) {	// 노드 개수만큼
                if (A[u.node][i] != 0) {	// 해당 노드로 진입하는 엣지가 있으면
                    if (D[i].size() < K) {	// K보다 작으면 => 추가 가능
                        D[i].add(u.w + A[u.node][i]);	// 최단경로 우선순위 큐 배열 갱신
                        pq.add(new Node(i, u.w + A[u.node][i]));	// 노드 추가
                    }
                    //  K와 같으면
                    else if (D[i].peek() > u.w + A[u.node][i]) {	// 새로 들어오는 노드가 해당노드보다 경로값이 작으면
                        D[i].poll();	// 제일 큰 값 삭제
                        D[i].add(u.w + A[u.node][i]);	// 새로 들어오는 최단경로 추가
                        pq.add(new Node(i, u.w + A[u.node][i]));	// 노드 추가
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {	// 노드 개수만큼
            if (D[i].size() == K)	// K 번까지 있으면
                bw.write(D[i].peek() + "\n");	// 해당노드의 K번째 최단경로값을 버퍼에 입력
                                                    // => 최단경로 우선순위 큐 배열은 오름차순 정렬이므로 꼭대기에 K번째 최단경로값 저장
            else	// K 번까지 없으면
                bw.write(-1 + "\n");	// -1 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init();

        Dijkstra();

        bw.flush();	// 출력 버퍼에 있는 값 전부 출력
        bw.close();	// 출력 버퍼 닫기
        bf.close();	// 입력 버퍼 닫기
    }
}