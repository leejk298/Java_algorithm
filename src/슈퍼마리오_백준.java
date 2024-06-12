import java.util.*;
import java.io.*;

/*
10
20
30
40
50
60
70
80
90
100
 */

public class 슈퍼마리오_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int sum = 0, answer = 0;    // 총합, 결과값

        for (int i = 0; i < 10; i++) {  // 10
            int num = Integer.parseInt(bf.readLine());  // 숫자

            if (sum < 100) {    // 총합 100보다 작으면
                sum += num; // 총합 갱신

                if (Math.abs(answer - 100) > Math.abs(sum - 100))   // 결과값이 더 작으면
                    answer = sum;   // 저장
                else if (Math.abs(answer - 100) == Math.abs(sum - 100)) // 같으면
                    answer = answer > sum ? answer : sum;   // 큰 수 저장
            }
        }

        System.out.println(answer); // 결과값 출력
    }
}
