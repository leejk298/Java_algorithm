import java.util.*;

public class 선물전달_조합_083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기

        int N = sc.nextInt(); // 몇 명
        int mod = 1000000000; // 나머지 연산
        int D[] = new int[N + 1]; // 경우의 수 배열

        D[1] = 0; // 1명은 선물교환 불가능 => 0
        D[2] = 1; // 2명은 양방향만 가능 => 1
        for (int i = 3; i <= N; i++) { // 3명부터 N명까지
            // (i - 1) : A가 (B, C, D, E, ...)를 선택할 경우의 수 => N - 1
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]); // D[i - 1]: 한 명만 선물교환 => 단반향일 때, 나머지 경우의 수
            // D[i - 2]: 두 명이 선물교환 => 양방향일 때, 나머지 경우의 수
            D[i] %= mod; // 나머지 연산
        }

        System.out.println(D[N]); // N명일 때 경우의 수 출력
    }
}
