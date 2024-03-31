import java.util.*;
import java.io.*;

/*
10 8 6
15 30
25 50
70 80
 */

public class 트럭주차_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int A = Integer.parseInt(st.nextToken());   // 한 대 요금
        int B = Integer.parseInt(st.nextToken());   // 두 대
        int C = Integer.parseInt(st.nextToken());   // 세 대

        int[] arr = new int[101];   // 초기화

        int min = 0, max = 0;   // 시간
        for (int i = 0; i < 3; i++) {   // 3개 만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 끝

            for (int j = S; j < E; j++) // 시간만큼
                arr[j]++;   // 주차 대수 추가

            min = Math.min(min, S); // 최소값
            max = Math.max(max, E); // 최대값
        }

        int sum = 0;    // 총 합
        for (int i = min; i <= max; i++) {  // 시간만큼
            if (arr[i] == 1)    // 한 대
                sum += A * arr[i];  // A 요금

            if (arr[i] == 2)    // 두 대
                sum += B * arr[i];  // B 요금

            if (arr[i] == 3)    // 세 대
                sum += C * arr[i];  // C 요금
        }

        System.out.println(sum);    // 총 합 출력
    }
}
