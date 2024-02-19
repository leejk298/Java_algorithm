import java.util.*;

public class 귤고르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {

            Map<Integer,Integer> hashMap = new HashMap<>(); // 해시맵
            for(int t : tangerine)  // 입력배열 순회
                hashMap.put(t, hashMap.getOrDefault(t, 0) + 1); // 해시맵 저장

            List<Integer> list = new ArrayList<>(hashMap.values()); // 리스트, 해시맵의 밸류값으로
            Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

            int count = 0, sum = 0; // 개수, 합
            for(int i : list) { // 리스트 순회
                sum += i;   // 개수 합
                count++;    // 종류 개수 카운트

                if(sum >= k)    // 합이 k 이상이면
                    break;  // for 종료
            }

            return count;   // 종류 개수 리턴
        }
    }
}
