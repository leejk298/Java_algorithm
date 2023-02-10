
public class 최적의행렬곱셈 {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{5, 3}, {3, 10}, {10, 6}, {6, 11}, {11, 13}, {13, 4}});
    }
}

class Solution {
    // 멤버 변수
    private int[][] matrix; // dp 배열
    private int[][] memo;   // 메모이제이션 배열

    // 멤버 함수
    public int solution(int[][] matrix_sizes) {
        this.matrix = matrix_sizes;
        this.memo = new int[matrix.length + 1][matrix.length + 1];

        return matrixMul(0, matrix.length);
    }

    private int memoization(int s, int e) {
        if (memo[s][e] == 0)    // 처음인 경우
            memo[s][e] = matrixMul(s, e);   // 재귀콜

        return memo[s][e];
    }

    private int matrixMul(int s, int e) {
        if (e - s == 1) // 이웃하면 비용이 안듬 => 2개이면 그대로 행렬 곱
            return 0;

        int ans = Integer.MAX_VALUE;    // 충분히 큰 값으로 설정
        for (int m = s + 1; m < e; m++) {   // 중앙값(m)을 이동시켜서 구간마다 작은 값 기억
            int left = memoization(s, m);  // LT, 메모이제이션
            int right = memoization(m, e); // GT
            int current = matrix[s][0] * matrix[m][0] * matrix[e - 1][1];   //  BottomUp

            ans = Math.min(ans, left + right + current);    // 작은 값으로 설정
        }

        return ans;
    }
}