public class 다음에올숫자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 4, 8}));
    }

    static class Solution {
        public int solution(int[] common) {
            int flag = -1;
            int plus = common[1] - common[0];
            int mul = 0;
            if(common[0] != 0)
                mul = common[1] / common[0];

            if(common[1] + plus == common[2])
                flag = 0;
            else if(common[1] * mul == common[2])
                flag = 1;

            if(flag == 0)
                return common[common.length - 1] + plus;
            else
                return common[common.length - 1] * mul;
        }
    }
}
