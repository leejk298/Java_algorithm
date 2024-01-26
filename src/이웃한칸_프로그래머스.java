public class 이웃한칸_프로그래머스 {
    static class Solution {
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        public static boolean isNotValidPos(int x, int y, String[][] board) {   // 좌표가 유효한지
            return (x < 0 || x >= board.length || y < 0 || y >= board[0].length);
        }

        public static int BFS(String[][] board, int x, int y) { // BFS

            String now = board[x][y];   // 현재 색깔
            int count = 0;  // 개수

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

                if(isNotValidPos(tmpX, tmpY, board))    // 유효한지
                    continue;

                if(board[tmpX][tmpY].equals(now))   // 현재 색깔과 같으면
                    count++;    // 개수 카운트
            }

            return count;   // 개수 리턴
        }

        public int solution(String[][] board, int h, int w) {

            return BFS(board, h, w);    // BFS
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]
                {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}},
                1, 1));
    }
}
