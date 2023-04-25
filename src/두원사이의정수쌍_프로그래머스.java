public class 두원사이의정수쌍_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 3));
    }

    static class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            for(int i = 1; i <= r2; i++) {  // 1부터 큰 원의 반지름까지
                long min = (long)Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));  // 작은 경계
                long max = (long)Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i)); // 큰 경계값

                answer += max - min + 1;    // 사이의 좌표 개수
            }

            return answer * 4;  // 4개의 사분면
        }
    }
}
