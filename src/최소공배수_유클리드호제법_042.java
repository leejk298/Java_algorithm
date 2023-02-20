import java.util.Scanner;

public class 최소공배수_유클리드호제법_042 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기

        for (int i = 0; i < N; i++) { // 크기 만큼
            int a = sc.nextInt(); // 숫자 1
            int b = sc.nextInt(); // 숫자 2

            int res = a * b / gcd(a, b); // 최소 공배수

            System.out.println(res); // 출력
        }
    }

    private static int gcd(int a, int b) { // 최대 공약수 함수
        // 베이스케이스
        if (b == 0) // 나머지가 0 이면
            return a; // 최대공약수 a 리턴

            // 재귀케이스
        else
            return gcd(b, a % b); // 재귀콜, (작은 수, 큰 수 % 작은 수)
    }
}
