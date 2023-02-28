import java.util.Arrays;

public class 입국심사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[] {7, 10}));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times);

            long l = 0;
            long r = (long)n * times[times.length - 1];   // 최악의 경우
            while(l <= r) {
                long mid = (l + r) / 2;
                long sum = 0;

                for(int i = 0; i < times.length; i++)
                    sum += mid / times[i];

                if(sum < n)
                    l = mid + 1;
                else {
                    r = mid - 1;
                    answer = mid;
                }
            }

            return answer;
        }
    }
}
