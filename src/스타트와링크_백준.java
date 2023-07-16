import java.io.*;
import java.util.*;

/*
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
 */

public class 스타트와링크_백준 {
    static int N, min;  // 크기, 최소값
    static int[][] arr; // 입력배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        min = Integer.MAX_VALUE;    // 최소값

        // 초기화
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {   // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < N; j++) // 열
                arr[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static int diff() {  // 차이

        int start = 0, link = 0;    // 스타트, 링크

        for (int i = 0; i < N - 1; i++) {   // 첫 번째
            for (int j = i + 1; j < N; j++) {   // 두 번째
                if (visited[i] && visited[j])   // 스타트
                    start += arr[i][j] + arr[j][i];

                else if (!visited[i] && !visited[j])    // 링크
                    link += arr[i][j] + arr[j][i];
            }
        }

        return Math.abs(start - link);  // 차이, 절대값
    }

    public static void DFS(int depth, int index) {  // DFS, 브루트포스

        if (depth == N / 2) {   // 도달하면
            min = Math.min(min, diff());    // 최소값 구하기

            return; // 함수 리턴, 완전 탐색 위해
        }

        // 도달 못했으면
        for (int i = index; i < N; i++) {   // index 부터 크기까지
            if (!visited[i]) {  // 방문한 적이 없으면
                visited[i] = true;  // 방문
                DFS(depth + 1, i + 1);  //  재귀콜, DFS
                visited[i] = false; // 리턴되면 방문여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0);  // DFS, (깊이 0부터, 인덱스 0부터)

        System.out.println(min);    // 최소값 출력
    }
}
