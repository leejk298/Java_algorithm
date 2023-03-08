public class 연속펄스부분수열의합_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 3, -6, 1, 3, -1, 2, 4}));
    }

    static class Solution {
        public long solution(int[] sequence) {
            int len = sequence.length;
            long[] sum = new long[len + 1]; // 합 배열

            for(int i = 1; i < len + 1; i++) {  // 구간합
                if(i % 2 == 0) {    // 짝 -1
                    sum[i] = sum[i - 1] + sequence[i - 1] * -1;
                } else {    // 홀 1
                    sum[i] = sum[i - 1] + sequence[i - 1];
                }
            }

            long max = -100001, min = 100001;   // 최대, 최소
            for(long i : sum) { // 부호 차이만 나므로
                if(i > max)
                    max = i;
                if(i < min)
                    min = i;
            }

            return max - min;
        }
    }
}
