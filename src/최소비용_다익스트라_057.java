import java.util.*;
import java.io.*;

public class 최소비용_다익스트라_057 {
    public static ArrayList<kNode>[] A; // 인접리스트
    public static boolean visited[]; // 방문배열
    public static int D[]; // 최단경로배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼

        int N = Integer.parseInt(bf.readLine()); // 노드
        int M = Integer.parseInt(bf.readLine()); // 엣지

        A = new ArrayList[N + 1]; // 인접리스트 선언
        visited = new boolean[N + 1]; // 방문배열 선언
        D = new int[N + 1]; // 최단경로배열 선언

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            A[i] = new ArrayList<kNode>(); // 인접리스트 구현
            D[i] = Integer.MAX_VALUE; // 최단경로배열 초기화
        }

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            A[S].add(new kNode(E, W)); // 인접리스트 연결, 방향, 가중치 => 노드 클래스 생성
        }

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int start = Integer.parseInt(st.nextToken()); // 출발노드
        int end = Integer.parseInt(st.nextToken()); // 도착노드

        System.out.println(dijkstra_cost(start, end)); // 다익스트라 함수 호출
    }

    private static int dijkstra_cost(int start, int end) { // 다익스트라 함수
        PriorityQueue<kNode> pq = new PriorityQueue<>(); // 우선순위 큐 => Comparable 클래스 구현 => compareTo 메소드 재정의
        pq.add(new kNode(start, 0)); // 출발노드 큐에 삽입
        D[start] = 0; // 최단경로배열 갱신

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지않으면
            kNode now = pq.poll(); // 하나 꺼내어
            int nowNode = now.node; // 해당 노드

            if (!visited[nowNode]) { // 방문하지않았으면
                visited[nowNode] = true; // 방문여부 갱신

                for (kNode i : A[nowNode]) { // 해당 노드의 인접리스트 순회하여
                    if (!visited[i.node] && D[i.node] > D[nowNode] + i.w) { // 인접리스트가 방문 X, 최단경로 갱신 필요하면
                        D[i.node] = D[nowNode] + i.w; // 최단경로 갱신
                        pq.add(new kNode(i.node, D[i.node])); // 우선순위 큐에 추가
                    }
                }
            }
        }

        return D[end]; // 도착노드까지의 최소비용 리턴
    }
}

class kNode implements Comparable<kNode> { // kNode 클래스
    int node;
    int w;

    kNode(int node, int w) {
        this.node = node;
        this.w = w;
    }

    @Override
    public int compareTo(kNode v) { // 오버라이딩
        return w - v.w;	// 오름차순 정렬
    }
}