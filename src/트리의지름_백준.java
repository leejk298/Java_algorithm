import java.util.*;
import java.io.*;

/*
12
1 2 3
1 3 2
2 4 5
3 5 11
3 6 9
4 7 1
4 8 7
5 9 15
5 10 4
6 11 6
6 12 10
 */

public class 트리의지름_백준 {
    static int N, D, furthestNode;  // 크기, 지름, 가장 먼 노드
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열

    static class Node { // 노드 클래스
        int v, w;   // 정점, 가중치

        public Node(int v, int w) { // 파라미터 생성자
            this.v = v;
            this.w = w;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        D = 0;  // 지름 0으로 초기화

        // 초기화
        A = new List[N + 1];
        for(int i = 1; i <= N; i++) // 크기만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 1; i < N; i++) {    // N - 1 만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            A[S].add(new Node(E, W));   // 양방향
            A[E].add(new Node(S, W));
        }
    }

    public static void DFS(int v, int w) {  // DFS

        // 베이스케이스
        if(visited[v])  // 방문한 적이 있으면
            return; // 리턴

        // 재귀케이스
        visited[v] = true;  // 방문한 적이 없으면 방문

        if(D < w) { // 최대값
            D = w;  // 최대값 갱신
            furthestNode = v;   // 가장 먼 노드 저장
        }

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 크기만큼
            Node next = A[v].get(i);    // 다음 노드

            if(!visited[next.v])    // 방문한 적이 없으면
                DFS(next.v, w + next.w);    // DFS, 재귀콜
        }
    }

    public static void printLength() {  // 지름 출력

        if(N > 1) { // 정점 개수가 1보다 크면
            visited = new boolean[N + 1];   // 방문배열 초기화
            DFS(1, 0);  // DFS, 1번 노드부터 가장 먼 노드 구하기

            visited = new boolean[N + 1];   // 방문배열 초기화
            DFS(furthestNode, 0);   // DFS, 가장 먼 노드로 가장 먼 거리 구하기
        }

        System.out.println(D);  // 지름 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printLength();  // 지름 출력
    }
}
