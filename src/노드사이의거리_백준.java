import java.util.*;
import java.io.*;

/*
4 2
2 1 2
4 3 2
1 4 3
1 2
3 2
 */

public class 노드사이의거리_백준 {
    static int N, M;    // 크기
    static List<int[]> list;    // 좌표리스트
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열

    static class Node { // 내부 클래스
        int v, w;   // 정점, 가중치

        public Node(int v, int w) {    // 파라미터 생성자
            this.v = v;
            this.w = w;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 찾을 개수

        // 초기화
        A = new List[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < N - 1; i++) {   // N - 1 만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            A[S].add(new Node(E, W));   // 양방향
            A[E].add(new Node(S, W));
        }

        for (int i = 0; i < M; i++) {   // 찾을 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int start = Integer.parseInt(st.nextToken());   // 시작
            int end = Integer.parseInt(st.nextToken()); // 도착

            list.add(new int[]{start, end});    // 리스트 저장
        }
    }

    public static int BFS(int s, int e) {   // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(s, 0));    // 큐에 시작점과 거리 0인 노드 추가
        visited[s] = true;  // 시작점 방문
        int D = 0;  // 거리 0 => 종료 조건에서 저장 후 리턴하기 위해

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            if (now.v == e) {   // 도착점에 도달하면
                D = now.w;  // 거리 저장

                break;  // while() 종료
            }

            for (int i = 0; i < A[now.v].size(); i++) { // 현재 정점의 인접리스트 개수만큼
                Node next = A[now.v].get(i);    // 다음 노드

                if (!visited[next.v]) { // 방문한 적이 없으면
                    visited[next.v] = true; // 방문
                    queue.offer(new Node(next.v, now.w + next.w));  // 큐에 삽입
                }
            }
        }

        return D;   // 거리값 리턴
    }

    public static void printDistance() {    // 노드 사이의 거리 출력

        for (int i = 0; i < M; i++) {   // 찾을 개수만큼
            int[] pos = list.get(i);    // 좌표

            int start = pos[0], end = pos[1];   // 시작, 도착점
            visited = new boolean[N + 1];   // 방문배열 초기화

            System.out.println(BFS(start, end));    // BFS, 거리 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printDistance();    // 노드 사이의 거리 출력
    }
}
