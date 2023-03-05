import java.util.*;

public class 단속카메라_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{-20, -15}, {-14, -5}, {-18, -13}, {-5,-3}}));
    }

    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0; // 개수

            // 구간 끝 오름차순 정렬 => 다음 구간 시작과 비교하여 끊기면 카메라 설치 필요
            Arrays.sort(routes, new Comparator<int []>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];   // 구간 끝
                }
            });

            int max = Integer.MIN_VALUE;    // 작은 값으로 초기화
            for(int[] r : routes) { // 구간마다
                if(max < r[0]) {    // 큰 값이면
                    max = r[1];     // 설정 => 해당 구간 끝 값과 다음 구간 시작 비교
                    answer++;       // 횟수 카운트
                }
            }

            return answer;
        }
    }
}
