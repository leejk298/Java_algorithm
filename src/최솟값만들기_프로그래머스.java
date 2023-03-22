import java.util.*;

public class 최솟값만들기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 4, 2}, new int[] {5, 4, 4}));
    }

    static class Solution {
        public int solution(int []A, int []B) {
            int answer = 0;
            int len = A.length;

            Arrays.sort(A);
            Arrays.sort(B);

            for(int i = 0; i < len; i++)
                answer += A[i] * B[len - 1 - i];

            return answer;
        }
    }
}
