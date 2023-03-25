import java.util.*;

public class 연속부분수열합의개수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {7, 9, 1, 1, 4}));
    }

    static class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            int len = elements.length;

            for(int i = 1; i <= len; i++) {
                for(int j = 0; j < len; j++) {
                    int sum = 0;

                    for(int k = 0; k < i; k++) {
                        int num = (j + k) % len;
                        sum += elements[num];
                    }

                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}
