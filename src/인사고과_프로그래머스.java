import java.util.*;

public class 인사고과_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }

    static class Solution {
        public int solution(int[][] scores) {

            int answer = 1; // 순위
            int wanhoScore = scores[0][0] + scores[0][1];   // 완호 점수 총합
            int[] w = {scores[0][0], scores[0][1]}; // 완호 점수 배열

            Arrays.sort(scores, (o1, o2) -> {   // 하나를 기준으로 => 근무태도
                if (o1[0] == o2[0])  // 근무태도가 같으면
                    return o1[1] - o2[1];   // 동료평가 오름차순으로

                return o2[0] - o1[0];   // 근무태도가 다르면 근무태도 내림차순 정렬
            });

            int max = -1;   // 기준값

            for (int[] score : scores) { // 입력배열 순회
                if (max < score[1])  // 기준값보다 크면
                    max = score[1]; // 갱신
                else if (max > score[1]) {   // 작으면
                    if (score[0] == w[0] && score[1] == w[1])    // 완호인지 체크
                        return -1;
                    else    // 완호가 아니면
                        continue;   // 다음 사람으로 => 이미 오름차순 정렬했으므로 순위 체크 x
                }

                if (score[0] + score[1] > wanhoScore)    // 갱신이 된 경우에는 완호의 점수보다 크면
                    answer++;   // 완호 순위 갱신
            }

            return answer;  // 완호 순위 리턴
        }
    }
}
