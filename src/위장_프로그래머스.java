import java.util.*;

public class 위장_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> hashMap = new HashMap<>();

            for(String[] cloth : clothes) {
                hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
            }

            for(String str : hashMap.keySet()) {
                answer *= (hashMap.get(str) + 1);   // 선택 X 포함
            }

            return answer - 1;  // 전부 선택 X만 제외
        }
    }
}
