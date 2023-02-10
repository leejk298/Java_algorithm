import java.util.Scanner;

public class 거의소수_에라토스테네스의체_038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        long Min = sc.nextLong();	// 시작
        long Max = sc.nextLong();	// 끝
        long A[] = new long[10000001];	// 배열 크기 : 10^7

        for (int i = 2; i < A.length; i++)	// 크기 만큼
            A[i] = i;	// 배열 저장

        for (int i = 2; i <= Math.sqrt(A.length); i++) {	// 제곱근까지 비교하여
            if (A[i] == 0)	// 소수가 아니면 통과
                continue;

            // 소수이면
            for (int j = i + i; j < A.length; j = j + i)	// 해당 숫자의 배수
                A[j] = 0;	// 소수가 아닌 수로 설정
        }

        int cnt = 0;	// 소수 개수 카운트

        for (int i = 2; i < A.length; i++) {	// 크기 만큼
            if (A[i] != 0) {	// 거의소수이면
                long tmp = A[i];	// 해당 숫자 저장

                while ((double) A[i] <= (double) (Max / tmp)) {	// 이항정리 => 소수의 제곱이 Max 보다 작을 때까지
                    if ((double) A[i] >= (double) (Min / tmp))	// 이항정리 => 소수의 제곱이 Min 보다 크면
                        cnt++;	// 개수 카운트

                    tmp = tmp * A[i];	// 다시 이항정리
                }
            }
        }

        System.out.println(cnt);	// 개수 출력
    }
}
