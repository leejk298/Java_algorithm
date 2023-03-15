import java.util.*;

public class HIndex_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 0, 6, 1, 5}));
    }

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            for(int i = 0; i < citations.length; i++) {
                int h = citations.length - i;
                int max = Math.min(citations[i], h);

                if(max >= answer)
                    answer = max;
                else
                    break;
            }

            return answer;
        }
    }
}
