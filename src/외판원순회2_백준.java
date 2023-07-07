import java.util.*;
import java.io.*;

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */

public class 외판원순회2_백준 {
    static int N, res;  // 크기
    static int[][] arr; // 입력배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        arr = new int[N][N];
        res = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {    // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < N; j++)  // 열
                arr[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static void DFS(int depth, int s, int e, int sum) {  // DFS, 브루트포스

        if(depth == N - 1) {    // 전부 다 연결되면
            if(arr[e][s] != 0) {    // 마지막 정점에서 시작 정점으로 가는 길이 있으면
                sum += arr[e][s];   // 연결 => 순회해야하므로
                res = Math.min(res, sum);   // 최소 비용 저장
            }

            return; // 함수 리턴, 완전탐색하기 위해
        }

        // 연결되지 않았으면
        for(int i = 0; i < N; i++) {    // 행
            if(!visited[i] && arr[e][i] != 0) { // 방문하지않았고 길이 있으면
                visited[i] = true;  // 방문
                DFS(depth + 1, s, i, sum + arr[e][i]);  // DFS, 재귀 콜
                visited[i] = false; // 리턴되면 방문 여부 갱신
            }
        }
    }

    public static void findMinValue() { // 최소 비용 찾기

        for(int i = 0; i < N; i++) {    // 모든 정점에 대해
            visited = new boolean[N];   // 방문배열 초기화
            visited[i] = true;  // 방문
            DFS(0, i, i, 0);    // DFS
        }

        System.out.println(res);    // 최소 비용 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findMinValue(); // 최소 비용 찾기
    }
}
