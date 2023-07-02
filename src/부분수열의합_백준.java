import java.util.*;
import java.io.*;

/*
5 0
-7 -3 -2 5 8
 */

public class 부분수열의합_백준 {
    static int N, S, res;   // 크기, 결과값
    static int[] arr;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        S = Integer.parseInt(st.nextToken());   // 합
        res = 0;    // 결과값

        arr = new int[N];   // 입력배열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
    }

    public static void DFS(int depth, int sum) {    // 브루트포스

        if(depth == N) {    // 도달하면
            if(S == sum)    // 합과 같으면
                res++;  // 개수 카운트

            return; // 리턴, 완전탐색
        }

        DFS(depth + 1, sum + arr[depth]);   // 다음 원소와 같이 더하여
        DFS(depth + 1, sum);    // 자신 그대로
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0);  // DFS, 브루트포스

        if(S == 0)  // 0이면
            System.out.println(res - 1);    // 전체가 0일 때와 그대로 0인 것과 같으므로 -1
        else    // 아니면
            System.out.println(res);    // 결과 출력
    }
}
