import java.io.*;
import java.util.*;

/*
1 2 1
 */

public class 수퍼바이러스_소프티어 {
    static final int mod = 1000000007;  // mod
    public static long recursion(long P, long N) {  // 재귀

        if(N == 1)  // 베이스케이스
            return P;   // N이 1이면 P 리턴

        // 재귀케이스, N이 1이 아니면
        long num = recursion(P, N / 2); // 재귀콜, N / 2

        // (2, 10) -> (2, 5) * (2, 5)
        // (2, 5) -> (2, 2) * (2, 2) * (2, 1)
        // (2, 2) -> (2, 1) * (2, 1)
        // (2, 1) -> 2

        if(N % 2 == 0)  // 짝수이면
            return num * num % mod; // 원래값으로
        else    // 홀수이면
            return (num * num % mod) * P % mod; // 몫만큼 곱해줌
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        long K = Long.parseLong(st.nextToken());    // K 마리
        long P = Long.parseLong(st.nextToken());    // P 배
        long N = Long.parseLong(st.nextToken());    // N 초

        long res = recursion(P, 10 * N);    // 재귀

        System.out.println(K * res % mod);  // 결과값 출력, K * res => mod 연산 필요
    }
}
