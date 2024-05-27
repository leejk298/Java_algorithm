import java.util.*;
import java.io.*;

/*
3
 */

public class 모든순열_백준 {
    static int N;   // 크기
    static int[] arr;   // 결과배열
    static boolean[] visited;   // 방문배열

    public static void DFS(int depth) { // DFS

        if (depth == N) {   // 베이스케이스: 깊이가 N과 같으면
            for (int i = 0; i < N; i++) // 크기만큼
                System.out.print(arr[i] + " "); // 결과배열 출력

            System.out.println();   // 개행문자 출력

            return; // 완전탐색하기 위해 리턴
        }

        //재귀케이스: 깊이가 N과 같지 않으면
        for (int i = 0; i < N; i++) {   //  크기만큼
            if (!visited[i]) {  // 방문한 적이 없으면
                arr[depth] = i + 1; // 결과배열에 값 저장
                visited[i] = true;  // 방문

                DFS(depth + 1); // DFS 재귀콜

                visited[i] = false; // 방문여부 초기화
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        arr = new int[N];   // 결과배열
        visited = new boolean[N];   // 방문배열

        DFS(0); // DFS
    }
}
