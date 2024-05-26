import java.util.*;
import java.io.*;

/*
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
 */

public class 순열싸이클_백준 {
    static int[] arr;   // 입력배열
    static boolean[] visited;   // 방문배열

    public static void DFS(int v) {   // DFS

        if (visited[v]) // 베이스케이스: 방문한 적이 있으면
            return; // 리턴

        // 재귀케이스: 방문한 적이 없으면
        visited[v] = true;  // 방문
        int next = arr[v];  // 다음 정점

        if (!visited[next]) // 방문하지 않았으면
            DFS(next);  // DFS 재귀콜
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int T = Integer.parseInt(bf.readLine());    // 테스트 횟수

        StringBuilder sb = new StringBuilder(); // 결과문자열

        while (T-- > 0) {   // 테스트 횟수만큼
            int N = Integer.parseInt(bf.readLine());    // 크기

            arr = new int[N + 1];   // 입력배열
            visited = new boolean[N + 1];   // 방문배열

            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int i = 1; i <= N; i++)    // 크기만큼
                arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

            int count = 0;  // 개수
            for (int i = 1; i <= N; i++) {  // 크기만큼
                if (!visited[i]) {  // 방문한 적이 없으면
                    DFS(i);  // DFS
                    count++; // 개수 카운트
                }
            }

            sb.append(count + "\n");    // 결과문자열에 개수 추가
        }

        System.out.print(sb);   // 결과문자열 출력
    }
}
