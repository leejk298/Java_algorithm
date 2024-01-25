import java.util.*;

public class 귤고르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {

            Map<Integer, Integer> hashMap = new HashMap<>();    // 해시맵

            for(int t : tangerine)  // 입력배열 순회
                hashMap.put(t, hashMap.getOrDefault(t, 0) + 1); // 해시맵 저장

            List<Integer> list = new ArrayList<>(); // 리스트
            for(int key : hashMap.keySet()) // 키 값 순회
                list.add(hashMap.get(key)); // 밸류 값 리스트에 저장

            Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

            int sum = 0, answer = 0;    // 총 합, 결과값
            for(int i : list) { // 리스트 순회
                sum += i;   // 총합 갱신
                answer++;   // 가짓수

                if(sum >= k)    // 필요 개수 이상이면
                    break;  // for 종료
            }

            return answer;  // 결과값 리턴
        }
    }
}
