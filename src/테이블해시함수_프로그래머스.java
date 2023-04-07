import java.util.*;

public class 테이블해시함수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}},
                2, 2, 3));
    }

    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;

            Arrays.sort(data, (o1, o2) -> { // 정렬
                return (o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1]);
            });

            for(int i = row_begin - 1; i <= row_end - 1; i++) {
                int sum = 0;
                for(int num : data[i]) { // S_i
                    sum += num % (i + 1);
                }

                answer ^= sum; // XOR
            }

            return answer;
        }
    }
}
