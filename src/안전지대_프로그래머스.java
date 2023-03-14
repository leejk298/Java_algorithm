public class 안전지대_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
    }

    static class Solution {
        public int solution(int[][] board) {
            int[][] copy = new int[board.length][board.length];
            int answer = 0;

            for(int i = 0; i < board.length; i++)
                for(int j = 0; j < board.length; j++)
                    if(board[i][j] == 1)
                        checkAround(i, j, copy);

            for(int[] arr : copy)
                for(int i : arr)
                    if(i == 0)
                        answer++;

            return answer;
        }

        static void checkAround(int x, int y, int[][] copy) {
            int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
            int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

            for(int i = 0; i < 9; i++) {
                int tmpX = dx[i] + x;
                int tmpY = dy[i] + y;

                if(tmpX >= 0 && tmpX < copy.length && tmpY >= 0 && tmpY < copy.length)
                    copy[tmpX][tmpY] = 1;
            }
        }
    }
}
