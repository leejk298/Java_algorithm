import java.util.*;

public class 귤고르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for(int i : tangerine)
                map.put(i, map.getOrDefault(i, 0) + 1);

            List<Integer> arr = new ArrayList<>();
            for(int i : map.keySet())   // map의 key를 가져와서
                arr.add(map.get(i));    // key에 해당하는 value 삽입

            Collections.sort(arr, Collections.reverseOrder());

            int sum = 0;
            for(int i : arr) {
                sum += i;
                answer++;

                if(sum >= k)
                    break;
            }

            return answer;
        }
    }
}
