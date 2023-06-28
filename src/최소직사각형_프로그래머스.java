import java.util.*;

public class 최소직사각형_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    static class Solution {
        public int solution(int[][] sizes) {

            // 초기화
            int answer = 0; // 결과값
            List<Integer> min = new ArrayList<>();  // 최소
            List<Integer> max = new ArrayList<>();  // 최대

            for(int[] s : sizes) {  // 입력배열 순회
                if(s[0] < s[1]) {   // 비교
                    min.add(s[0]);
                    max.add(s[1]);
                } else {
                    min.add(s[1]);
                    max.add(s[0]);
                }
            }

            // 내림차순 정렬
            Collections.sort(min, Collections.reverseOrder());
            Collections.sort(max, Collections.reverseOrder());

            answer = min.get(0) * max.get(0);   // 제일 큰 넓이

            return answer;  // 결과 리턴
        }
    }
}
