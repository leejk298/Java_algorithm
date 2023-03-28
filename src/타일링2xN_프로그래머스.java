public class 타일링2xN_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        public int solution(int n) {
            int mod = 1000000007;
            int[] arr = new int[n];

            arr[0] = 1;
            arr[1] = 2;
            for(int i = 2; i < n; i++) {
                int sum = arr[i - 1] + arr[i - 2];

                arr[i] = sum % mod;
            }

            return arr[n - 1];
        }
    }
}
