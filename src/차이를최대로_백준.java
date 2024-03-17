import java.util.*;
import java.io.*;

/*
6
20 1 15 8 4 10
 */

public class 차이를최대로_백준 {
    static int N, max;  // 크기, 결과값
    static int[] arr, A;    // 입력배열, 결과배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        max = Integer.MIN_VALUE;    // 결과값

        arr = new int[N];   // 입력배열
        A = new int[N];     // 결과배열
        visited = new boolean[N];   // 방문배열

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
    }

    public static void DFS(int depth) { // DFS, 브루트포스

        // 베이스케이스
        if(depth == N) {    // 크기와 같으면
            int sum = 0;    // 총 합

            for(int i = 0; i < N - 1; i++)
                sum += Math.abs(A[i] - A[i + 1]);   // 총 합 저장

            max = Math.max(max, sum);   // 최대값 갱신

            return; // 함수 리턴, 완전 탐색하기 위해
        }

        // 재귀케이스: 크기와 다르면
        for(int i = 0; i < N; i++) {    // 크기만큼
            if(!visited[i]) {   // 방문한 적이 없으면
                visited[i] = true;  // 방문
                A[depth] = arr[i];  // 결과배열 저장

                DFS(depth + 1); // 재귀콜

                visited[i] = false; // 리턴되면 방문 여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0); // DFS, 브루트포스

        System.out.println(max);    // 결과값 출력
    }
}
