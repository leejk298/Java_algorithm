import java.util.*;

/*
3 2
1 2
3 4
5 6
2 3
-1 -2 0
0 0 3
 */

public class 행렬곱셈_백준 {
    static int N, M, K; // 크기
    static int[][] A, B, sum;   // 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        A = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                A[i][j] = sc.nextInt();

        M = sc.nextInt();   // 행
        K = sc.nextInt();   // 열

        // 초기화
        B = new int[M][K];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < K; j++)
                B[i][j] = sc.nextInt();

        sum = new int[N][K];    // 결과배열 초기화
    }

    public static void printMatrix() {  // 곱셈 행렬 출력

        for (int i = 0; i < N; i++) // 행
            for (int j = 0; j < K; j++) // 열
                for (int k = 0; k < M; k++) // 중간 연산
                    sum[i][j] += A[i][k] * B[k][j]; // 결과배열

        // 출력
        for (int[] s : sum) {   // 행
            for (int i : s) {   // 열
                System.out.print(i + " ");  // 값 출력
            }

            System.out.println();   // 개행문자 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMatrix();  // 곱 행렬 출력
    }
}
