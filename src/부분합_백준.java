import java.util.*;
import java.io.*;

/*
10 15
5 1 3 5 10 7 4 9 2 8
 */

public class 부분합_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int S = Integer.parseInt(st.nextToken());   // 합

        int[] arr = new int[N]; // 입력배열 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for (int i = 0; i < N; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int res = 100001;   // 길이 최대값, 100000 + 1

        int s = 0, e = 0, sum = 0;  // 인덱스, 구간합
        while (true) {
            if(sum >= S) {  // 구간합이 주어진 합보다 크거나 같으면
                sum -= arr[s];  // 구간합 갱신
                res = Math.min(res, e - s); // 길이 저장

                s++;    // 시작인덱스 갱신
            } else if(e == N) { // 끝인덱스가 N에 도달하면
                break;  // while 종료
            } else {    // 끝에 도달하지 않았고 합보다 작으면
                sum += arr[e];  // 구간합 갱신

                e++;    // 끝인덱스 갱신
            }
        }

        if (res == 100001)  // 초기값 그대로이면 같은 값이 없는 것이므로
            System.out.println(0);  // 0 출력
        else    // 아니면
            System.out.println(res);    // 구간합 최소 길이 출력
    }
}
