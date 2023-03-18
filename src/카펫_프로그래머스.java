import java.util.Arrays;

public class 카펫_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(10, 2)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int sum = brown + yellow;

            for(int i = 1; i <= sum; i++) {
                int row = i;
                int col = sum / row;

                if(row > col)
                    continue;

                if((row - 2) * (col - 2) == yellow) {
                    answer[0] = col;
                    answer[1] = row;

                    break;
                }
            }

            return answer;
        }
    }
}
