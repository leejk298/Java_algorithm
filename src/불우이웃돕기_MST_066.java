import java.io.*;
import java.util.*;

public class 불우이웃돕기_MST_066 {
    static int N, sum;
    static PriorityQueue<aEdge> pq; // 엣지리스트
    static int parent[]; // 대표노드

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        N = Integer.parseInt(bf.readLine()); // 노드 개수

        // 엣지리스트 -> 우선순위 큐 -> 가중치 오름차순 정렬 -> Comparable 인터페이스 구현 -> compareTo() 메소드 구현
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) { // 노드 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
            char ch[] = st.nextToken().toCharArray(); // 문자열을 문자 하나씩 저장하여

            for (int j = 0; j < N; j++) { // 노드 개수만큼
                int tmp = 0; // 각 행의 합

                if (ch[j] >= 'a' && ch[j] <= 'z') // 소문자이면
                    tmp = ch[j] - 'a' + 1; // a부터 1

                if (ch[j] >= 'A' && ch[j] <= 'Z') // 대문자이면
                    tmp = ch[j] - 'A' + 'a' + 1; // A부터 27

                sum += tmp; // 모든 행의 합

                if (i != j && tmp != 0) // 인접행렬에서 i != j이고 값이 있으면
                    pq.add(new aEdge(i, j, tmp)); // 엣지리스트에 저장
            }
        }

        parent = new int[N]; // 대표노드 초기화
        for (int i = 0; i < N; i++) // 해당 index로 대표노드 저장
            parent[i] = i;

        int useEdge = 0; // 사용된 엣지 수 => 노드 0 번부터 시작하므로 맞춰줌
        int res = 0; // 결과값

        while (!pq.isEmpty()) { // 큐가 비어있지않으면
            aEdge now = pq.poll(); // 하나 꺼내어

            if (find(now.S) != find(now.E)) { // 서로 대표노드가 다르면
                union(now.S, now.E); // 합집합
                res += now.W; // 결과에 가중치 더해줌
                useEdge++; // 사용된 엣지 수 + 1
            }
        }

        if (useEdge == N - 1) // 사용된 엣지 수가 N - 1 이면
            System.out.println(sum - res); // 기부할 수 있는 총 랜선 길이 출력
        else // 아니면 -1 출력
            System.out.println(-1);
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

class aEdge implements Comparable<aEdge> { // 엣지 클래스
    int S, E, W;

    public aEdge(int S, int E, int W) { // 파라미터 생성자
        this.S = S;
        this.E = E;
        this.W = W;
    }

    @Override
    public int compareTo(aEdge E) { // 오버라이딩
        return this.W - E.W; // 오름차순 정렬
    }
}
