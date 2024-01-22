import java.util.*;

public class 요격시스템_프로그래머스 {
    static class Solution {
        public int solution(int[][] targets) {
            Arrays.sort(targets, (o1, o2) -> {
                return o1[1] - o2[1];
            }); // 끝나는 시간을 기준으로 오름차순 정렬 => 스케줄링

            int answer = 0, end = 0;    // 결과값, 기준 시간
            for (int[] target : targets) {  // 입력배열 순회
                if (target[0] >= end) { // 끝나는 시간에 맞출 수 있으면
                    answer++;   // 개수 카운트
                    end = target[1];    // 기준 시간 갱신
                }
            }

            return answer;  // 결과값 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}
