import java.io.*;
import java.util.*;

/*
5
3 2 1 4 5
 */

public class 징검다리_소프티어 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        // 초기화
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
            dp[i] = 1;  // dp 배열 1로 초기화
        }

        int answer = 1; // 결과값, 최소 1
        for(int i = 0; i < N; i++) {    // 크기만큼
            for(int j = 0; j < i; j++) {    // 이전 값과 비교
                if(arr[i] > arr[j]) {   // 해당 값이 더 크면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp 배열 갱신
                }
            }

            answer = Math.max(answer, dp[i]);   // 결과값 갱신
        }

        System.out.println(answer); // 결과값 출력
    }
}
