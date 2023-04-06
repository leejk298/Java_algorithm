public class 마법의엘리베이터_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5467251));
    }

    static class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey > 0) {
                int one = storey % 10;      // 일의 자리
                int ten = (storey / 10) % 10;   // 십의 자리

                if(one < 5) {   // 5보다 작으면
                    answer += one;  // -
                } else if(one > 5) {    // 5보다 크면
                    answer += 10 - one; // -
                    storey += 10;       // 하나 올림
                } else {    // 5이면
                    answer += one;  // -

                    if(ten >= 5)    // 십의 자리가 5이상이면
                        storey += 10;   // 올림
                }

                storey /= 10;   // 다음 자릿수
            }

            return answer;
        }
    }
}
