public class N개의최소공배수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 6, 8, 14}));
    }

    static class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            if(arr.length == 1) // 원소 한 개면
                return arr[0];

            int gcd = GCD(arr[0], arr[1]);  // 최대공약수
            answer = (arr[0] * arr[1]) / gcd;   // 최소공배수

            if(arr.length > 2) {    // 3개 이상
                for(int i = 2; i < arr.length; i++) {
                    gcd = GCD(answer, arr[i]);
                    answer = (answer * arr[i]) / gcd;
                }
            }

            return answer;
        }

        static int GCD(int a, int b) {
            if(b == 0)
                return a;

            return GCD(b, a % b);
        }
    }
}
