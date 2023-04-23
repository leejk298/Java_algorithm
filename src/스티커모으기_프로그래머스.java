public class 스티커모으기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10}));
    }

    static class Solution {
        public int solution(int sticker[]) {
            int answer = 0;
            int len = sticker.length;

            if(len == 1)
                return sticker[0];

            int[] dp1 = new int[len];
            int[] dp2 = new int[len];

            dp1[0] = sticker[0];
            dp1[1] = sticker[0];
            for(int i = 2; i < len - 1; i++)
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);

            dp2[0] = 0;
            dp2[1] = sticker[1];
            for(int i = 2; i < len; i++)
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);

            answer = Math.max(dp1[len - 2], dp2[len - 1]);

            return answer;
        }
    }
}
