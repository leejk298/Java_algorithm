public class 멀쩡한사각형_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 12));
    }

    static class Solution {
        public long solution(int w, int h) {
            int gcd = GCD(w, h);
            long answer = (long)w * (long)h - ((long)w / gcd + (long)h / gcd - 1) * gcd;

            return answer;
        }

        public int GCD(int a, int b) {
            if(b == 0)
                return a;

            return GCD(b, a % b);
        }
    }
}
