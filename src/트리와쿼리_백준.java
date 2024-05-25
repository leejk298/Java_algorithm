import java.io.*;
import java.util.*;

/*
9 5 3
1 3
4 3
5 4
5 6
6 7
2 3
9 6
6 8
5
4
8
 */

public class 트리와쿼리_백준 {
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] dp;    // dp 배열

    public static int countNode(int v) {    // 노드개수 찾기

        visited[v] = true;  // 방문

        int count = 1;  // 개수 1부터

        if (dp[v] == 0) {   // 초기화 상태이면
            for (int next : A[v]) { // 해당 노드의 인접리스트 순회
                if (!visited[next]) {   // 방문한 적이 없으면
                    count += countNode(next);   // 개수 카운트
                    visited[next] = true;   // 방문
                }
            }

            dp[v] = count;  // dp 배열 갱신
        }

        return dp[v];   // 개수 리턴
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 개수
        int R = Integer.parseInt(st.nextToken());   // 루트
        int Q = Integer.parseInt(st.nextToken());   // 쿼리

        A = new List[N + 1];    // 인접리스트
        dp = new int[N + 1];    // dp 배열
        visited = new boolean[N + 1];   // 방문배열

        for (int i = 1; i <= N; i++)    // 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 1; i < N; i++) {   // N - 1만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작점
            int e = Integer.parseInt(st.nextToken());   // 도착점

            A[s].add(e);    // 양방향
            A[e].add(s);
        }

        countNode(R);   // 노드 개수 찾기

        StringBuilder sb = new StringBuilder(); // 결과문자열

        while (Q-- > 0) {   // 쿼리 개수만큼
            int num = Integer.parseInt(bf.readLine());  // 노드 번호

            sb.append(dp[num] + "\n");  // 개수
        }

        System.out.print(sb);   // 결과 출력
    }
}
