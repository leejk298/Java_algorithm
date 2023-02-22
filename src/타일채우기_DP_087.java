import java.util.*;

public class 타일채우기_DP_087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int mod = 10007; // 나머지 연산
        int N = sc.nextInt(); // 2 x N 타일
        long D[] = new long[N + 1]; // 타일 개수 배열

        D[1] = 1; // 2 X 1 타일은 1개
        D[2] = 2; // 2 X 2 타일은 (2 X 1) 2개, (1 X 2) 2개로 채워지므로 2개
        for (int i = 3; i <= N; i++) { // 3부터 N까지
            D[i] = (D[i - 1] + D[i - 2]) % mod; // 점화식, 나머지 연산
        }

        System.out.println(D[N]); // 2 X N 타일 개수 출력
    }
}
