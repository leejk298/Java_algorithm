import java.util.*;

public class 명예의전당_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
    }

    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < score.length; i++) {
                list.add(score[i]);
                Collections.sort(list);

                if(i < k - 1) {
                    answer[i] = list.get(0);
                } else {
                    answer[i] = list.get(i + 1 - k);
                }
            }

            return answer;
        }
    }
}
