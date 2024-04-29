public class 가장큰정사각형찾기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 1, 1, 1},
                {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }

    static class Solution {
        public int solution(int[][] board) {

            int max = 0;    // 한 변의 최대 길이

            for (int i = 0; i < board.length; i++) { // 행
                for (int j = 0; j < board[i].length; j++) { // 열
                    if (board[i][j] == 1 && i > 0 && j > 0)    // (1, 1)부터 배열 값이 1이면
                        board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;    // 좌, 상, 대각선 중 최소값 + 1

                    if (max < board[i][j])  // 최대값보다 크면
                        max = board[i][j];  // 최대값 갱신
                }
            }

            return max * max;   // 넓이 리턴
        }
    }
}
