public class 기사단원의무기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 3, 2));
    }

    static class Solution {
        public int solution(int number, int limit, int power) {

            int[] count = new int[number + 1];  // 결과배열

            count[1] = 1;   // 초기화
            for (int i = 2; i <= number; i++) {  // 2부터 길이만큼
                for (int j = 1; j * j <= i; j++) {   // 제곱근까지
                    if (j * j == i)  // 제곱근이면
                        count[i]++; // 개수 카운트

                    else if (i % j == 0) // 나누어 떨어지면
                        count[i] += 2;  // 2를 더해줌
                }

                if (count[i] > limit)    // 경계값보다 크면
                    count[i] = power;   // 파워값 저장
            }

            int answer = 0; // 결과값

            for (int i = 1; i <= number; i++)    // 길이만큼
                answer += count[i]; // 결과값 갱신

            return answer;  // 결과값 리턴
        }
    }
}
