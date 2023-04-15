import java.util.Arrays;

public class 카카오컬러링북DFS_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 4,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    static class Solution {
        static int numberOfArea;
        static int maxSizeOfOneArea;
        static int temp_cnt = 0;
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public static void DFS(int x,int y, int[][] picture, boolean[][] check){
            check[x][y] = true;
            temp_cnt++;

            for(int i = 0; i < 4; i++){
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if(tmpX < 0 || tmpX >= picture.length || tmpY < 0 || tmpY >= picture[0].length)
                    continue;

                if(picture[x][y] == picture[tmpX][tmpY] && !check[tmpX][tmpY])
                    DFS(tmpX, tmpY, picture, check);
            }
        }

        public int[] solution(int m, int n, int[][] picture) {
            numberOfArea = 0;
            maxSizeOfOneArea = 0;
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            boolean[][] check = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0 ;j < n; j++) {
                    if(picture[i][j] != 0 && !check[i][j]) {
                        numberOfArea++;
                        DFS(i,j,picture,check);
                    }

                    if(temp_cnt > maxSizeOfOneArea)
                        maxSizeOfOneArea = temp_cnt;

                    temp_cnt = 0;
                }
            }

            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            return answer;
        }
    }
}
