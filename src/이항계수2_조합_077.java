import java.util.*;

public class 이항계수2_조합_077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int K = sc.nextInt(); // 선택
        int D[][] = new int[N + 1][N + 1]; // 조합배열

        for (int i = 0; i <= N; i++) { // N 포함하여 N + 1만큼
            D[i][0] = 1; // i 개중 하나도 선택하지 않은 경우의 수: 1개
            D[i][1] = i; // i 개중 1개만 선택한 경우의 수: i개
            D[i][i] = 1; // i 개중 i개 전부 선택한 경우의 수: 1개
        }

        for (int i = 3; i <= N; i++) {// 총 개수
            for (int j = 2; j < i; j++) {// 선택 수
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j]; // 조합의 점화식
                D[i][j] %= 10007; // mod 연산
            }
        }
        System.out.println(D[N][K]); // nCr 값 출력
    }

}
