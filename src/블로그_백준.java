import java.util.*;
import java.io.*;

/*
5 2
1 4 2 5 1
 */

public class 블로그_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int X = Integer.parseInt(st.nextToken());   // 개수

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int[] arr = new int[N]; // 초기화
        for (int i = 0; i < N; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int sum = 0;    // 합
        for (int i = 0; i < X; i++) // 개수만큼
            sum += arr[i];  // 합 계산

        int max = sum, count = 1;   // 최대값, 개수
        for (int i = X; i < N; i++) {   // X부터 N까지
            sum += arr[i] - arr[i - X]; // 합 계산

            if (max == sum) // 최대값과 같으면
                count++;    // 개수 카운트
            else if (max < sum) {   // 합이 더 크면
                max = sum;  // 최대값 갱신
                count = 1;  // 개수 초기화
            }
        }

        if (max == 0)   // 최대값이 0이면
            System.out.println("SAD");  // SAD 출력
        else {  // 0이 아니면
            System.out.println(max);    // 최대값 출력
            System.out.println(count);  // 개수 출력
        }
    }
}
