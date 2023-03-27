import java.util.*;

public class 과일장수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length - 1; i >= 0; i--)
                if((score.length - i) % m == 0)
                    answer += score[i] * m;

            return answer;
        }
    }
}
