public class 다음큰숫자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(78));
    }

    static class Solution {
        public int solution(int n) {
            // bitCount(): 2진수 변환 후 1의 개수 리턴
            int count = Integer.bitCount(n);

            int count2 = 0;
            while(count != count2) {
                n++;
                count2 = Integer.bitCount(n);
            }

            return n;
        }
    }
}
