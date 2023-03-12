public class 기사단원의무기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 3, 2));
    }

    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] count = new int[number + 1];
            count[1] = 1;
            for(int i = 2; i <= number; i++) {
                for(int j = 1; j * j <= i; j++) {
                    if(j * j == i)
                        count[i]++;

                    else if(i % j == 0)
                        count[i] += 2;
                }

                if(count[i] > limit)
                    count[i] = power;
            }

            for(int i = 1; i <= number; i++)
                answer += count[i];

            return answer;
        }
    }
}
