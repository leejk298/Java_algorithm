public class 옹알이_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"aya", "yee", "u", "maa", "wyeoo"}));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            for(int i = 0; i < babbling.length; i++) {
                String str = babbling[i];
                String[] check = str.split("aya|ye|woo|ma");

                if(check.length == 0)
                    answer++;
            }

            return answer;
        }
    }
}
