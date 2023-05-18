import java.io.*;
import java.util.*;

public class 최소신장트리_MST_064 {
    static int parent[]; // 대표노드

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 엣지 개수

        PriorityQueue<wEdge> pq = new PriorityQueue<>(); // 우선순위 큐 => 엣지리스트
        parent = new int[N + 1]; // 대포노드 초기화

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            parent[i] = i; // 자신의 인덱스로 설정

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            pq.add(new wEdge(S, E, W)); // 엣지리스트 저장 => 가중치 오름차순 정렬
        }

        int res = 0; // 최소 비용
        for (int i = 0; i < N - 1; i++) { // N - 1 번
            wEdge now = pq.poll(); // 하나 꺼내어

            if (find(now.S) != find(now.E)) { // 대표 노드가 다르면
                union(now.S, now.E); // 합집합
                res += now.W; // 비용 갱신
            }
        }

        System.out.println(res); // 비용 출력
    }

    private static void union(int a, int b) { // 합집합
        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a;
    }

    private static int find(int a) { // find
        if (a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }
}

class wEdge implements Comparable<wEdge> { // 엣지 클래스 => Comparable 인터페이스 구현 => compareTo() 메소드 재정의
    int S, E, W;

    public wEdge(int S, int E, int W) {
        this.S = S;
        this.E = E;
        this.W = W;
    }

    @Override
    public int compareTo(wEdge E) { // 오버라이딩
        return this.W - E.W; // 오름차순 정렬
    }
}
