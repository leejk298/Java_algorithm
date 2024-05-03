import java.util.*;

public class 연속부분수열합의개수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{7, 9, 1, 1, 4}));
    }

    static class Solution {
        public int solution(int[] elements) {

            Set<Integer> hashSet = new HashSet<>(); // 집합, 중복제거
            int len = elements.length;  // 길이

            for (int i = 1; i <= len; i++) {    // 몇 회전
                for (int j = 0; j < len; j++) { // 현재 인덱스
                    int sum = 0;    // 총 합

                    for (int k = 0; k < i; k++) // 연속 몇 번까지
                        sum += elements[(j + k) % len]; // 합 갱신

                    hashSet.add(sum);   // 집합에 삽입, 중복제거
                }
            }

            return hashSet.size();  // 총 개수 리턴
        }
    }
}
