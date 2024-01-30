import java.util.*;

public class 보석쇼핑_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }

    static class Solution {
        public int[] solution(String[] gems) {

            int len = gems.length;  // 길이
            Set<String> set = new HashSet<>();  // 해시셋
            Map<String, Integer> map = new HashMap<>(); // 해시맵
            Queue<String> queue = new LinkedList<>();   // 큐

            for(int i = 0; i < len; i++)    // 길이만큼
                set.add(gems[i]);   // 입력배열 저장

            int S = 0, E = 0;   // 인덱스
            for(int i = 0; i < gems.length; i++) {  // 길이만큼
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1); // 해시맵 저장

                queue.add(gems[i]); // 큐에 삽입
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
