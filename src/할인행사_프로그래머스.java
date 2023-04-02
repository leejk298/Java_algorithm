import java.util.*;

public class 할인행사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1},
                new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            Map<String, Integer> wMap = new HashMap<>();    // 원하는 제품
            for(int i = 0; i < want.length; i++)    // 길이만큼
                wMap.put(want[i], number[i]);   // (제품, 개수) 저장

            Map<String, Integer> dMap = new HashMap<>();    // 할인 제품
            for(int i = 0; i < 10; i ++)    // 처음 10일치만큼
                dMap.put(discount[i], dMap.getOrDefault(discount[i], 0) + 1);   // 저장

            if(isBuyAllItem(wMap, dMap))    // 원하는 제품 전부 살 수 있는지
                answer++;

            for(int i = 1; i <= discount.length - 10; i++) { // 할인하는 날짜 만큼 전부 비교
                dMap.put(discount[i - 1], dMap.get(discount[i - 1]) - 1);   // 이전 상품 제거
                dMap.put(discount[i - 1 + 10], dMap.getOrDefault(discount[i - 1 + 10], 0) + 1); // 이후 상품 추가

                if(isBuyAllItem(wMap, dMap))
                    answer++;
            }

            return answer;
        }

        static boolean isBuyAllItem(Map<String, Integer> wMap, Map<String, Integer> dMap) {
            for(String s : wMap.keySet()) { // 원하는 제품 하나씩 꺼내서
                if(wMap.get(s) > dMap.getOrDefault(s, 0))   // 할인 제품보다 원하는 제품의 개수가 많으면 거짓
                    return false;
            }
            // 모든 상품에 대해
            // 원하는 제품 <= 할인 제품
            return true;
        }
    }
}
