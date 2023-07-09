import java.util.*;

public class 귤고르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {

            int answer = 0; // 결과값

            Map<Integer, Integer> map = new HashMap<>();    // 해시맵
            for(int i : tangerine)  // 입력배열 순회
                map.put(i, map.getOrDefault(i, 0) + 1); // 해시맵 저장

            List<Integer> arr = new ArrayList<>();  // 결과리스트
            for(int i : map.keySet())   // map의 key를 가져와서
                arr.add(map.get(i));    // key에 해당하는 value 삽입

            Collections.sort(arr, Collections.reverseOrder());  // 내림차순 정렬

            int sum = 0;    // 총 합
            for(int i : arr) {  // 리스트 순회
                sum += i;   // 합 갱신
                answer++;   // 개수

                if(sum >= k)    // 크면
                    break;  // for 종료
            }

            return answer;  // 총 개수 리턴
        }
    }
}
