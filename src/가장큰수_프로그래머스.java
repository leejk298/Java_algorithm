import java.util.*;

public class 가장큰수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 30, 34, 5, 9}));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] num = new String[numbers.length];

            for(int i = 0; i < num.length; i++)
                num[i] = String.valueOf(numbers[i]);

            Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            if(num[0].equals("0"))
                return "0";

            for(int i = 0; i < num.length; i++)
                answer += num[i];

            return answer;
        }
    }
}
