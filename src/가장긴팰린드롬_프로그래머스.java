public class 가장긴팰린드롬_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcdcba"));
    }

    static class Solution {
        public int solution(String s) {

            for(int i = s.length(); i > 0; i--) {
                for(int j = 0; j + i <= s.length(); j++) {
                    boolean isPalindrome = true;
                    for(int k = 0; k < i / 2; k++) {
                        if(s.charAt(j + k) != s.charAt(j - k + i - 1)) {
                            isPalindrome = false;
                            break;
                        }
                    }

                    if(isPalindrome)
                        return i;
                }
            }

            return 1;
        }
    }
}
