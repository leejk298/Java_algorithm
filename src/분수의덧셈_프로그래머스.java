import java.util.Arrays;

public class 분수의덧셈_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(1, 2, 3, 4)));
    }

    static class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {
            int[] answer = new int[2];

            int sumA = numer1 * denom2 + numer2 * denom1;
            int sumB = denom1 * denom2;
            int iGcd =  gcd(sumA, sumB);

            answer[0] = sumA / iGcd;
            answer[1] = sumB / iGcd;

            return answer;
        }

        static int gcd(int x, int y) {
            if(y == 0)
                return x;

            return gcd(y, x % y);
        }
    }
}
