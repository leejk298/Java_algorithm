import java.util.*;

public class 다각형넓이_기하_100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int N = sc.nextInt(); // 개수
        long x[] = new long[N + 1]; // x좌표, 크기: N + 1 => 마지막에 한 번 더 곱하기위해
        long y[] = new long[N + 1]; // y좌표

        for (int i = 0; i < N; i++) { // 초기화
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        x[N] = x[0]; // 마지막 값 세팅
        y[N] = y[0];

        double res = 0.0; // 결과
        for (int i = 0; i < N; i++) // CCW 총합
            res += x[i] * y[i + 1] - x[i + 1] * y[i];

        String area = String.format("%.1f", Math.abs(res) / 2.0); // 소수점 둘 째 자리에서 반올림
        System.out.println(area); // 넓이 출력
    }

}
