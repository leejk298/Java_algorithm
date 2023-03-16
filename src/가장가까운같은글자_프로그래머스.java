import java.util.*;

public class 가장가까운같은글자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("banana ")));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            HashMap<Character, Integer> map = new HashMap<>();

            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                answer[i] = i - map.getOrDefault(ch,i + 1);
                map.put(ch, i);
            }

            return answer;
        }
    }
}
