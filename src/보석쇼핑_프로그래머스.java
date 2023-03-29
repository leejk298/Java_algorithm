import java.util.*;

public class 보석쇼핑_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }

    static class Solution {
        public int[] solution(String[] gems) {
            int len = gems.length;
            Set<String> set = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();
            Queue<String> queue = new LinkedList<>();

            for(int i = 0; i < len; i++)
                set.add(gems[i]);

            int S = 0, E = 0;
            for(int i = 0; i < gems.length; i++) {
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

                queue.add(gems[i]);
                while(true) {
                    String s = queue.peek();

                    if(map.get(s) > 1) {
                        map.put(s, map.get(s) - 1);
                        queue.poll();
                        E++;
                    } else
                        break;
                }

                if(map.size() == set.size()) {
                    if(len > queue.size()) {
                        len = queue.size();
                        S = E;
                    }
                }
            }

            return new int[] {S + 1, S + len};
        }
    }
}
