import java.io.*;
import java.util.*;

/*
5 3
10 50 20 70 100
1 3
1 4
1 5
 */

public class 성적평균_소프티어 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        // 초기화
        int N = Integer.parseInt(st.nextToken());   // 크기
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1]; // 합배열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for(int i = 1; i <= N; i++)   // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1]; // 합배열 저장

        StringBuilder sb = new StringBuilder(); // 결과문자열

        for(int i = 0; i < K; i++) {    // 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 끝

            int sum = arr[E] - arr[S - 1];  // 구간합
            int count = E - S + 1;  // 개수

            String res = String.format("%.2f", (double)sum / count);    // 소수점 셋째자리에서 반올림해서 둘째자리까지 출력
            sb.append(res + "\n");  // 결과문자열에 추가
        }

        System.out.print(sb);   // 결과문자열 출력
    }
}
