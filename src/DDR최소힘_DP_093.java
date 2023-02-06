import java.util.*;

public class DDR최소힘_DP_093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int D[][][] = new int[100001][5][5]; // 점화식 배열
        // 드는 힘 배열
        int W[][] = { { 0, 2, 2, 2, 2 }, { 2, 1, 3, 4, 3 }, { 2, 3, 1, 3, 4 }, { 2, 4, 3, 1, 3 }, { 2, 3, 4, 3, 1 } };

        for (int i = 0; i < 5; i++) // 왼
            for (int j = 0; j < 5; j++) // 오
                for (int k = 0; k < 100001; k++) // 최대 100000
                    D[k][i][j] = 100001 * 4; // 충분히 큰 값으로 설정

        D[0][0][0] = 0; // 출발할 때 드는 힘은 0
        int N, S = 1; // 수열 N, 시작 S는 1부터
        while (true) {
            N = sc.nextInt(); // 수열 하나 입력받아
            if (N == 0) // 0 이면 수열 끝이므로
                break; // 반복문 종료

            // 1. 오른발 이동
            for (int i = 0; i < 5; i++) { // 왼
                if (i == N) // (왼발 == 오른발)은 출발점 외에는 불가능
                    continue; // 건너뜀

                for (int j = 0; j < 5; j++) { // 오
                    D[S][i][N] = Math.min(D[S - 1][i][j] + W[j][N], D[S][i][N]);
                    // 오른발을 옮겨 현재 모습이 되었을 때 최소힘 구하기
                }
            }

            // 2. 왼발 이동
            for (int j = 0; j < 5; j++) { // 오
                if (j == N) // (오른발 == 왼발)은 출발점 외에는 불가능
                    continue; // 건너뜀

                for (int i = 0; i < 5; i++) { // 왼
                    D[S][N][j] = Math.min(D[S - 1][i][j] + W[i][N], D[S][N][j]);
                    // 왼발을 옮겨 현재 모습이 되었을 떄 최소힘 구하기
                }
            }

            S++; // 다음 발판으로 이동
        }

        S--; // while문이 끝나면 수열길이 + 1 이므로 하나 줄여줌

        int min = Integer.MAX_VALUE; // 충분히 큰 값으로 설정하여 최소값 구하기
        for (int i = 0; i < 5; i++) // 왼
            for (int j = 0; j < 5; j++) // 오
                min = Math.min(min, D[S][i][j]); // 최소값 구하기

        System.out.println(min); // 출력
    }
}
