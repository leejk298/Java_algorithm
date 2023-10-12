public class 안전지대_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
    }

    static class Solution {
        public static void checkAround(int x, int y, int[][] copy) {    // BFS

            int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};  // 9방향
            int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

            for(int i = 0; i < 9; i++) {    // 9방향만큼
                int tmpX = dx[i] + x;   // 다음 좌표
                int tmpY = dy[i] + y;

                if(tmpX >= 0 && tmpX < copy.length && tmpY >= 0 && tmpY < copy.length)   // 유효하면
                    copy[tmpX][tmpY] = 1;   // 1
            }
        }
        public int solution(int[][] board) {

            int[][] copy = new int[board.length][board.length]; // 복사배열
            int answer = 0; // 결과값

            for(int i = 0; i < board.length; i++)   // 행
                for(int j = 0; j < board.length; j++)   // 열
                    if(board[i][j] == 1)    // 1이면
                        checkAround(i, j, copy);    // BFS

            for(int[] arr : copy)   // 행
                for(int i : arr)    // 열
                    if(i == 0)  // 0이면
                        answer++;   // 개수 카운트

            return answer;  // 결과값
        }
    }
}
