import java.util.Scanner;

public class 제곱이아닌수_에라토스테네스의체_040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        long Min = sc.nextLong(); // 시작
        long Max = sc.nextLong(); // 끝

        boolean check[] = new boolean[(int) (Max - Min + 1)]; // 배열

        for (long i = 2; i * i <= Max; i++) { // 1 보다 큰 수부터 시작, 제곱수가 Max보다 작거나 같을때까지 비교
            long pow = i * i; // 제곱수
            long S = Min / pow; // 시작 인덱스

            if (Min % pow != 0) // 나머지가 0 이 아니면
                S++; // Min 보다 더 큰 제곱수에서 시작 => 배열 인덱스 맞춰주기위해

            for (long j = S; pow * j <= Max; j++) // 제곱수를 true로 고치기
                check[(int) ((j * pow) - Min)] = true;
        }

        int cnt = 0;

        for (int i = 0; i <= Max - Min; i++) // 크기 만큼
            if (!check[i]) // 제곱수가 아니면
                cnt++; // 카운트 세기

        System.out.println(cnt); // 출력
    }
}
