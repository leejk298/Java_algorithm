import java.util.Arrays;

public class 쿼드압축_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

    static class Solution {
        static int[] answer;    // 결과

        public int[] solution(int[][] arr) {

            answer = new int[2];    // 초기화
            int initSize = arr.length;  // 길이

            DFS(0, 0, arr, initSize);  // DFS, 브루트포스

            return answer;  // 결과 리턴
        }

        public static void DFS(int x, int y, int[][] arr, int size) {   // DFS
            // 베이스케이스
            if(checkZeroOrOne(x, y, arr, size)) {   // 다 같으면
                answer[arr[x][y]]++;    // 추가

                return; // 완전 탐색하기 위해 함수 리턴
            }

            // 재귀케이스
            DFS(x, y, arr, size / 2);   // 1
            DFS(x + size / 2, y, arr, size / 2);    // 2
            DFS(x, y + size / 2, arr, size / 2);    // 3
            DFS(x + size / 2, y + size / 2, arr, size / 2); // 4
        }

        public static boolean checkZeroOrOne(int x, int y, int[][] arr, int size) { // 유효한지

            for(int i = x; i < x + size; i++)   // 행
                for(int j = y; j < y + size; j++)   // 열
                    if(arr[x][y] != arr[i][j])  // 서로 다르면
                        return false;   // false

            return true; // 전부 다 같으면 true
        }
    }
}
