import java.util.*;

public class 최댓값과최솟값_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("-1 -2 -3 -4"));
    }

    static class Solution {
        public String solution(String s) {
            List<Integer> arr = new ArrayList<>();
            String[] str = s.split(" ");

            for(int i = 0; i < str.length; i++)
                arr.add(Integer.parseInt(str[i]));

            String answer = "" + Collections.min(arr) + " " + Collections.max(arr);

            return answer;
        }
    }
}
