import java.util.*;

/*
5 2
 */

public class 이항계수3_백준 {
    static long N, K;   // 크기
    final static long mod = 1000000007;

    public static long factorial(long N) {  // 팩토리얼

        long f = 1; // 곱셈이므로 1부터

        while(N > 1) {  // 1보다 크면 반복
            f = (f * N) % mod;  // f!
            N--;    // 크기 줄이기
        }

        return f;   // 합 리턴
    }

    public static long pow(long N, long E) {    // 제곱

        // 베이스케이스
        if(E == 1)
            return N % mod;

        // 재귀케이스
        long sum = pow(N, E / 2);   // 분할

        if(E % 2 == 0)  // 나누어떨어지면
            return sum * sum % mod; // 합 계산
        else    // 홀수이면
            return (sum * sum % mod) * N % mod; // 한 번 더 계산
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextLong();  // 크기
        K = sc.nextLong();

        long numerator = factorial(N);  // 분자, N!
        long denominator = factorial(K) * factorial(N - K) % mod;   // 분모, (K! * (N - K)!) % mod

        System.out.println(numerator * pow(denominator, mod - 2) % mod);    // N! * 분모의 역원((K! * (N - K)!)
    }
}
