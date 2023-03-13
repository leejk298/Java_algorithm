public class 체육복_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[] {2, 4}, new int[] {3}));
    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] check = new int[n + 2];   // 0 ~ n + 1 까지: 편의성

            for(int i = 0; i <= n + 1; i++) // 초기화
                check[i] = 1;

            for(int i = 0; i < lost.length; i++)    // 도난
                check[lost[i]]--;

            for(int i = 0; i < reserve.length; i++) // 여벌
                check[reserve[i]]++;

            for(int i = 1; i <= n; i++) {   // n명
                if(check[i] == 0) { // 0 이면
                    if(check[i - 1] == 2) { // 앞이 2벌
                        check[i]++;
                        check[i - 1]--;

                        continue;
                    }

                    if(check[i + 1] == 2) { // 뒤가 2벌
                        check[i]++;
                        check[i + 1]--;
                    }
                }
            }

            for(int i = 1; i <= n; i++) // n명
                if(check[i] >= 1)   // 체육 가능
                    answer++;

            return answer;
        }
    }
}
