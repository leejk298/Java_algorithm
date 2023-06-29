import java.util.*;

public class 시소짝궁_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {100, 180, 360, 100, 270}));
    }

    static class Solution {
        public long solution(int[] weights) {

            long answer = 0;    // 결과값
            Map<Double, Integer> hashMap = new HashMap<>(); // 해시맵

            Arrays.sort(weights);   // 오름차순 정렬

            for(int w : weights) {  // 입력배열 하나씩 순회
                double a = w * 1.0; // 1배
                double b = w * (3.0 / 4.0); // 3/4
                double c = w * (2.0 / 3.0); // 2/3
                double d = w * 0.5; // 1/2

                // 해시맵에 존재하는지, 존재하면 개수 카운트
                if(hashMap.containsKey(a))
                    answer += hashMap.get(a);
                if(hashMap.containsKey(b))
                    answer += hashMap.get(b);
                if(hashMap.containsKey(c))
                    answer += hashMap.get(c);
                if(hashMap.containsKey(d))
                    answer += hashMap.get(d);

                // 오름차순 정렬했으므로 마지막까지 비교 가능
                hashMap.put(a, hashMap.getOrDefault(a, 0) + 1); // 자신 추가
            }

            return answer;  // 총 합 리턴
        }
    }
}
