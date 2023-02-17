import java.util.*;

public class 이친수_DP_086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int N = sc.nextInt(); // 크기
        int D[][] = new int[2][N + 1]; // 배열

        D[0][1] = 0; // 1자리가 0으로 시작 => 이친수 X
        D[1][1] = 1; // 1자리가 1로 시작 => 이친수 O
        for (int i = 2; i <= N; i++) { // 2부터 N까지
            // 이전에 0이 오면 0, 1 가능, 이전에 1이 오면 0만 가능
            D[1][i] = D[0][i - 1]; // 1 -> 0
            D[0][i] = D[0][i - 1] + D[1][i - 1]; // 0 -> 0, 1
        }

        System.out.println(D[0][N] + D[1][N]); // N 자리 이친수 개수 출력
    }
}
