import java.util.*;

public class 구명보트_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {70, 50, 80, 50}, 100));
    }

    static class Solution {
        public int solution(int[] people, int limit) {

            int answer = 0; // 결과값

            Arrays.sort(people);    // 오름차순 정렬

            int i = 0, j = people.length - 1;   // 인덱스 설정
            while(i <= j) { // 역전이 아니면 반복
                if(people[i] + people[j] <= limit) {    // 조건에 만족하면
                    i++;
                    j--;
                } else  // 아니면
                    j--;

                answer++;   // 개수 카운트
            }

            return answer;  // 총 개수 리턴
        }
    }
}
