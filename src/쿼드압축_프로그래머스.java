import java.util.Arrays;

public class 쿼드압축_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

    static class Solution {
        private static int[] answer;

        public int[] solution(int[][] arr) {
            answer = new int[2];
            int initSize = arr.length;

            DivideAndConquer(0, 0, arr, initSize);

            return answer;
        }

        public static void DivideAndConquer(int x, int y, int[][] arr, int size) {
            if(checkZeroOrOne(x, y, arr, size)) {
                answer[arr[x][y]]++;

                return;
            }

            DivideAndConquer(x, y, arr, size / 2);
            DivideAndConquer(x + size / 2, y, arr, size / 2);
            DivideAndConquer(x, y + size / 2, arr, size / 2);
            DivideAndConquer(x + size / 2, y + size / 2, arr, size / 2);
        }

        public static boolean checkZeroOrOne(int x, int y, int[][] arr, int size) {
            for(int i = x; i < x + size; i++)
                for(int j = y; j < y + size; j++)
                    if(arr[x][y] != arr[i][j])
                        return false;

            return true;
        }
    }
}
