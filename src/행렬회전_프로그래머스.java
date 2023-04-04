import java.util.*;

public class 행렬회전_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }

    static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            List<Integer> list = new ArrayList<>(); // 결과 리스트
            int[][] board = new int[rows][columns];

            // 초기화
            int num = 1;
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < columns; j++)
                    board[i][j] = num++;

            for(int[] query : queries) {    // 구간
                int x1 = query[0] - 1;
                int y1 = query[1] - 1;
                int x2 = query[2] - 1;
                int y2 = query[3] - 1;
                int tmpNum = board[x1][y2]; // 맨 오른쪽 위 복사
                int min = tmpNum;

                for(int i = y2 - 1; i >= y1; i--) { // 우
                    min = Math.min(min, board[x1][i]);
                    board[x1][i + 1] = board[x1][i];
                }

                for(int i = x1 + 1; i <= x2; i++) { // 상
                    min = Math.min(min, board[i][y1]);
                    board[i - 1][y1] = board[i][y1];
                }

                for(int i = y1 + 1; i <= y2; i++) { // 좌
                    min = Math.min(min, board[x2][i]);
                    board[x2][i - 1] = board[x2][i];
                }

                for(int i = x2 - 1; i >= x1; i--) { // 하
                    min = Math.min(min, board[i][y2]);
                    board[i + 1][y2] = board[i][y2];
                }

                board[x1 + 1][y2] = tmpNum; // 복사
                list.add(min);  // 결과 리스트에 추가
            }

            return list.stream().mapToInt(i -> i).toArray();    // 배열로 리턴
        }
    }
}
