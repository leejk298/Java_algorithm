import java.io.*;
import java.util.*;

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */

public class 퇴사_백준 {
    static int N;   // 크기
    static int[] t, p, dp;  // 입력, dp 배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        t = new int[N];
        p = new int[N];
        dp = new int[N + 1];

        for(int i = 0; i < N; i++) {    // 크기만큼
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            t[i] = Integer.parseInt(st.nextToken());    // 소요 시간
            p[i] = Integer.parseInt(st.nextToken());    // 이득
        }
    }

    public static void printMaxValue() {    // 최대 이득 출력

        for(int i = 0; i < N; i++) {    // 크기만큼
            if(i + t[i] <= N)   // 해당하는 일 수 + 소요 시간이 총 시간을 넘지 않으면 => 유효한 기간이면
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);    // 일하고 난 다음 날에 최대 비용 저장

            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // 해당 날에 일을 못할 수도 있으므로 그 전의 값과 비교하여 저장
        }

        System.out.println(dp[N]);  // 마지막 날, 최대 비용 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기회

        printMaxValue();    // 최대 이득 출력
    }
}
