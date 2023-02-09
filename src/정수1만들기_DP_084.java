import java.util.*;

public class 정수1만들기_DP_084 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기

        int N = sc.nextInt(); // 숫자
        int D[] = new int[N + 1]; // 연산 결과배열

        D[1] = 0; // 1 일때는 연산이 필요없으므로 0으로 초기화
        for (int i = 2; i <= N; i++) { // 연산배열
            D[i] = D[i - 1] + 1; // - 1 연산

            if (i % 2 == 0) // 2의 배수 연산
                D[i] = Math.min(D[i], D[i / 2] + 1); // 최소값으로 설정

            if (i % 3 == 0) // 3의 배수 연산
                D[i] = Math.min(D[i], D[i / 3] + 1); // + 1 : 해당 연산횟수 포함하므로
        }

        System.out.println(D[N]); // 출력
    }
}
