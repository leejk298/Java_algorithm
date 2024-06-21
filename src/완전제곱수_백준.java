import java.util.*;
import java.io.*;

/*
60
100
 */

public class 완전제곱수_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int M = Integer.parseInt(bf.readLine());    // M
        int N = Integer.parseInt(bf.readLine());    // N

        int min = Integer.MAX_VALUE, sum = 0;   // 최소값, 총합

        for (int i = 0; i * i <= N; i++) {  // 제곱근까지
            if (i * i >= M && i * i <= N) { // M 이상 N 이하이면
                min = Math.min(i * i, min); // 최소값 갱신
                sum += i * i;   // 총합 갱신
            }
        }

        if (sum == 0)   // 초기값이면 => 완전제곱수가 없으면
            System.out.println(-1); // -1
        else    // 아니면
            System.out.println(sum + "\n" + min);   // 총합과 최소값 출력
    }
}
