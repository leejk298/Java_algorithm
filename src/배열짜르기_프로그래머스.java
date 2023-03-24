import java.util.*;

public class 배열짜르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 7, 14));
    }

    static class Solution {
        public List<Long> solution(int n, long left, long right) {
            List<Long> answer = new ArrayList<>();

            for(long i = left; i <= right; i++)
                answer.add(Math.max(i / n , i % n) + 1);

            return answer;
        }
    }
}
