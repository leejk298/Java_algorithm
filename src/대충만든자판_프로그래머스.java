import java.util.*;

public class 대충만든자판_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"})));
    }

    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<Character, Integer> map = new HashMap<>();

            for(String str : keymap) {
                for(int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);

                    if(!map.containsKey(ch) || i < map.get(ch)) {
                        map.put(ch, i + 1);
                    }
                }
            }


            for(int i = 0; i < targets.length; i++) {
                int count = 0;

                for(int j = 0; j < targets[i].length(); j++) {
                    char ch = targets[i].charAt(j);

                    if(!map.containsKey(ch)) {
                        count = 0;

                        break;
                    } else {
                        count += map.get(ch);
                    }
                }

                if(count == 0)
                    answer[i] = -1;
                else
                    answer[i] = count;
            }

            return answer;
        }
    }
}
