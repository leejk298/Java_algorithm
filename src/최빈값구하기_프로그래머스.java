public class 최빈값구하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 2, 3, 3, 3, 4}));
    }

    static class Solution {
        public int solution(int[] array) {
            int answer = 0;
            int cnt[] = new int[1000];
            int count = 0;

            for(int i = 0; i < array.length; i++) {
                cnt[array[i]]++;

                if(count < cnt[array[i]]) {
                    count = cnt[array[i]];
                    answer = array[i];
                }
            }

            int flag = 0;
            for(int i = 0; i < cnt.length; i++) {
                if(count == cnt[i])
                    flag++;
            }

            if(flag > 1)
                return -1;

            return answer;
        }
    }
}
