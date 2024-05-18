import java.util.*;

public class 보석쇼핑_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }

    static class Solution {
        public int[] solution(String[] gems) {

            Set<String> set = new HashSet<>();  // 해시셋
            Map<String, Integer> map = new HashMap<>(); // 해시맵
            Queue<String> queue = new LinkedList<>();   // 큐

            int len = gems.length;  // 길이
            for (int i = 0; i < len; i++)    // 길이만큼
                set.add(gems[i]);   // 입력배열 저장

            int S = 0, E = 0;   // 인덱스
            for (int i = 0; i < gems.length; i++) {  // 길이만큼
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1); // 해시맵 저장

                queue.add(gems[i]); // 큐에 삽입
                while (true) {
                    String s = queue.peek();    // top 위치의 값

                    if (map.get(s) > 1) {   // 1보다 크면
                        map.put(s, map.get(s) - 1); // 하나 줄이고
                        queue.poll();   // 꺼내기
                        E++;    // 끝인덱스 갱신
                    } else  // 1 이하이면
                        break;  // while 종료
                }

                if (map.size() == set.size()) { // 맵과 집합 크기가 같으면
                    if (len > queue.size()) {   // 길이가 더 크면
                        len = queue.size(); // 길이 갱신
                        S = E;  // 시작인덱스 갱신
                    }
                }
            }

            return new int[]{S + 1, S + len};
        }
    }
}
