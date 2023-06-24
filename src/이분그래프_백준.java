import java.util.*;
import java.io.*;

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 */

public class 이분그래프_백준 {
    static int N, M, T; // 크기
    static int[] check; // 이분그래프 판별배열
    static boolean[] visited;   // 방문배열
    static boolean isEven;  // 이분그래프 판별
    static List<Integer>[] A;   // 인접리스트

    public static void init(BufferedReader bf) throws IOException { // 초기화

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        check = new int[N + 1];
        isEven = true;

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            A[S].add(E);    // 양방향
            A[E].add(S);
        }
    }

    public static void DFS(int v) { // DFS

        // 베이스 케이스
//        if (visited[v]) // 방문한 적이 있으면 리턴
//            return;

        // 재귀 케이스
        visited[v] = true;  // 없으면 방문

        for (int i = 0; i < A[v].size(); i++) { // 해당 노드의 인접리스트 개수만큼
            int next = A[v].get(i); // 다음 노드

            if (!visited[next]) {   // 방문한 적이 없으면
                check[next] = (check[v] + 1) % 2;   // 이분그래프 설정: 0 아님 1
                DFS(next);  // DFS
            } else if (check[next] == check[v]) // 방문한 적이 있고 둘 다 같은 번호이면
                isEven = false; // 이분그래프가 아님
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        T = Integer.parseInt(bf.readLine());    // 테스트케이스 개수
        StringBuilder sb = new StringBuilder(); // 결과 문자열

        while (T-- > 0) {   // 개수 만큼

            init(bf);   // 초기화

            for (int i = 1; i <= N; i++) {  // 노드 개수만큼: 모든 정점 확인
                if (isEven) // 이분그래프이면: 초기값은 true
                    DFS(i); // DFS 수행
                else    // 아니면
                    break;  // 더 이상 for 수행 x
            }

            if (isEven) // 이분그래프이면
                sb.append("YES").append("\n");  // YES + 개행문자
            else    // 아니면
                sb.append("NO").append("\n");   // NO + 개행문자
        }

        System.out.print(sb);   // 결과 문자열 출력
    }
}
