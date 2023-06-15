import java.util.*;

/*
10 11 12
 */

public class 곱셈_백준 {

    public static long pow(int a, int b, int mod) { // 제곱

        // 베이스 케이스
        if(b == 0)
            return 1;

        // 재귀 케이스
        long sum = pow(a, b / 2, mod);  // 분할

        if(b % 2 == 0)  // 나누어 떨어지면
            return sum * sum % mod; // 합 계산
        else    // 아니면
            return (sum * sum % mod) * a % mod; // a를 한 번 더 곱해줌
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int A = sc.nextInt();   // A
        int B = sc.nextInt();   // B
        int C = sc.nextInt();   // C

        System.out.println(pow(A, B, C));   // 제곱 계산
    }
}
