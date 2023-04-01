import java.util.*;

public class 성격유형검사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"},
                new int[] {5, 3, 2, 7, 5}));
    }

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            Map<Character, Integer> hashMap = new HashMap<>();

            for(int i = 0; i < survey.length; i++) {
                int num = choices[i];

                if(num > 0 && num < 4) {
                    char ch = survey[i].charAt(0);
                    hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 4 - num);
                } else {
                    char ch = survey[i].charAt(1);
                    hashMap.put(ch, hashMap.getOrDefault(ch, 0) + num - 4);
                }
            }


            return new StringBuilder()
                    .append(hashMap.getOrDefault('R', 0) < hashMap.getOrDefault('T', 0) ? 'T' : 'R')
                    .append(hashMap.getOrDefault('C', 0) < hashMap.getOrDefault('F', 0) ? 'F' : 'C')
                    .append(hashMap.getOrDefault('J', 0) < hashMap.getOrDefault('M', 0) ? 'M' : 'J')
                    .append(hashMap.getOrDefault('A', 0) < hashMap.getOrDefault('N', 0) ? 'N' : 'A')
                    .toString();
        }
    }
}
