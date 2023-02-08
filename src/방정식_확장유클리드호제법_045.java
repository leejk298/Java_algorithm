import java.io.*;
import java.util.*;

public class 방정식_확장유클리드호제법_045 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int a = Integer.parseInt(st.nextToken()); // 숫자 1
        int b = Integer.parseInt(st.nextToken()); // 숫자 2
        int c = Integer.parseInt(st.nextToken()); // 숫자 3
        long gcd = gcd(a, b); // 최대공약수

        if (c % gcd != 0) // c가 최대공약수의 배수가 아니면
            System.out.println(-1); // -1 출력

        else { // 공약수의 배수이면
            int x = (int) (c / gcd); // 몫을 구하여
            long res[] = Excute(a, b); // 나머지 b가 0이 될 때까지 유클리드호제법 함수 호출

            System.out.println(res[0] * x + " " + res[1] * x); // 값 출력
        }
    }

    private static long[] Excute(int a, int b) { // 유클리드호제법 함수
        long res[] = new long[2]; // x, y

        if (b == 0) { // 0 이면
            res[0] = 1; // x를 1
            res[1] = 0; // y를 0으로 설정

            return res;
        }

        // 0이 아니면
        long p = a / b;
        long v[] = Excute(b, a % b); // 재귀호출
        res[0] = v[1]; // 역순으로 올라오면서 x 값
        res[1] = v[0] - v[1] * p;	// y 값 계산 로직

        return res;
    }

    private static long gcd(int a, int b) { // 최대공약수
        while (b != 0) { // 0 이 아니면
            int tmp = a % b; // 나머지 구하여
            a = b; // 스왑
            b = tmp;
        }

        return Math.abs(a); // 절대값
    }
}
