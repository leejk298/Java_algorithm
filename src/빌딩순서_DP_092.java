import java.util.*;

public class 빌딩순서_DP_092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 총 빌딩 개수
        int L = sc.nextInt(); // 왼쪽에서 본 빌딩 개수
        int R = sc.nextInt(); // 오른쪽에서 본 빌딩 개수
        long mod = 1000000007; // 나머지 연산
        long D[][][] = new long[N + 1][L + 1][R + 1]; // 점화식 배열

        D[1][1][1] = 1; // 빌딩 1개일 때 경우의 수는 1
        for (int i = 2; i <= N; i++) { // 빌딩 개수: 2 ~ N
            for (int j = 1; j <= L; j++) { // 왼
                for (int k = 1; k <= R; k++) { // 오
                    // N - 1 까지의 경우의 수를 안다고 가정하고 나머지 1개의 빌딩이
                    // 가장 작다고 했을 때 왼, 오, 가운데 배치 경우의 수를 더해줌
                    D[i][j][k] = ((D[i - 1][j][k] * (N - 2)) + D[i - 1][j - 1][k] + D[i - 1][j][k - 1]) % mod;
                    // 왼: L이 1 증가, 오: R이 1 증가
                    // 가운데에 배치할 경우 경우의 수가 증가하진 않지만 가운데 배치 경우가 N - 2개
                    // => 총 N에서 왼, 오 경우 빼면 N - 2 이므로
                }
            }
        }

        System.out.println(D[N][L][R]); // 값 출력
    }
}
