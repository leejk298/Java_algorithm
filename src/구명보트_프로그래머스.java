import java.util.*;

public class 구명보트_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {70, 50, 80, 50}, 100));
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            int i = 0, j = people.length - 1;
            while(i <= j) {
                if(people[i] + people[j] <= limit) {
                    i++;
                    j--;
                } else
                    j--;

                answer++;
            }

            return answer;
        }
    }
}
