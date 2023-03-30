import java.util.*;

public class 정수내림차순_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(118372));
    }

    static class Solution {
        public long solution(long n) {
            String str = String.valueOf(n);
            char[] ch = str.toCharArray();
            int[] arr = new int[str.length()];

            for(int i = 0; i < arr.length; i++) {
                arr[i] = ch[i] - '0';
            }

            Arrays.sort(arr);

            String s = "";
            for(int i = arr.length - 1; i >= 0 ; i--) {
                s += arr[i];
            }

            long answer = Long.parseLong(s);

            return answer;
        }
    }
}
