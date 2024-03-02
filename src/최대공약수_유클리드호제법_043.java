import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 최대공약수_유클리드호제법_043 {

    public static long gcd(long a, long b) {	// 최대공약수 함수

        if (b == 0)	// 베이스케이스
            return a;	// 최대공약수 리턴
        // 재귀케이스
        return gcd(b, a % b);	// 재귀콜
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);	// 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	// 출력 버퍼

        long a = sc.nextLong();	// 숫자 1
        long b = sc.nextLong();	// 숫자 2

        long res = gcd(a, b);	// 최대공약수

        while (res > 0) {	// 결과값이 0 보다 크면
            bw.write("1");	// 출력 버퍼에 1을 입력

            res--;	// 결과값 하나 줄이고
        }

        bw.flush();	// 출력 버퍼에 있는 값 출력
        bw.close();	// 출력 버퍼 닫기
    }
}
