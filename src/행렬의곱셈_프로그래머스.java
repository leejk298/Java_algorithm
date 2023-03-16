import java.util.Arrays;

public class 행렬의곱셈_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(new int[][] {{1, 4}, {3, 2}, {4, 1}},
                new int[][] {{3, 3}, {3, 3}})));
    }

    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            for(int i = 0; i < arr1.length; i++)
                for(int j = 0; j < arr2[0].length; j++)
                    for(int k = 0; k < arr1[0].length; k++)
                        answer[i][j] += arr1[i][k] * arr2[k][j];

            return answer;
        }
    }
}
