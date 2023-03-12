public class 기지국설치_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(11, new int[] {4, 11}, 1));
    }

    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int S = 1;  // 시작

            for(int i = 0; i < stations.length; i++) {
                if(S < stations[i] - w) {   // 범위에 벗어나면
                    int E = stations[i] - w - 1;    // 끝
                    answer += findCount(S, E, w);   // 개수 찾기
                }

                S = stations[i] + w + 1;    // 시작 범위 갱신
            }

            if(S - 1 < n)   // 반복문 끝나고 숫자가 남으면
                answer += findCount(S, n, w);   // 개수 찾기

            return answer;  // 개수 출력
        }

        static int findCount(int S, int E, int w) { // 개수 찾기 함수
            int count = (E - S + 1) / (2 * w + 1);  // 몫

            if((E - S + 1) % (2 * w + 1) > 0)   // 나머지가 0보다 크면 한 개 추가
                count++;

            return count;   // 개수 리턴
        }
    }
}
