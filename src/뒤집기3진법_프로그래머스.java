import java.util.*;

public class 뒤집기3진법_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(125));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();

            while(n > 0) {
                list.add(n % 3);

                n /= 3;
            }

            int num = 1;
            for(int i = list.size() - 1; i >= 0; i--) {
                answer += list.get(i) * num;
                num *= 3;
            }

            return answer;
        }
    }
}
