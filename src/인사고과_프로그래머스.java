import java.util.*;

public class 인사고과_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }

    static class Solution {
        public int solution(int[][] scores) {
            int answer = 1; // 등수 1등부터
            int wScore = scores[0][0] + scores[0][1];   // 원호 점수
            int[] w = {scores[0][0], scores[0][1]};     // 1차 배열로

            // 정렬: 근무태도 내림, 동료평가 오름차순 => 둘 다 같은 걸로 정렬하면 비교할 수 없으므로
            Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < scores.length; i++) {
                if(max < scores[i][1]) {
                    max = scores[i][1];
                } else if(max > scores[i][1]) { // 작으면
                    if(scores[i][0] == w[0] && scores[i][1] == w[1])    // 원호와 같으면 -1
                        return -1;

                    continue;   // 다음 반복으로
                }

                if(scores[i][0] + scores[i][1] > wScore)    // 원호보다 높으면
                    answer++;   // 등수 + 1
            }

            return answer;
        }
    }
}
