import java.util.*;

public class 복습1_0810 {
    static class Solution {
        static int answer;  // 결과값

        public static boolean isValid(int num) {    // 팰린드롬 수인지

            String str = num + "";  // 문자열로 변환

            int len = str.length(); // 문자열 길이
            for(int i = 0; i < len / 2; i++)    // 길이의 절반
                if(str.charAt(i) != str.charAt(len - 1 - i))    // 비교해서 다르면
                    return false;   // false 리턴

            return true;    // 전부 같으면 true 리턴
        }

        public static void findPalindrome(int n, int m) {   // 팰린드롬 수 찾기

            for(int i = n; i <= m; i++) // n부터 m까지
                if(isValid(i))  // 팰린드롬 수이면
                    answer++;   // 개수 카운트
        }

        public int solution(int n, int m) {

            answer = 0; // 개수 초기화

            findPalindrome(n, m);   // 팰린드롬 수 찾기

            return answer;  // 총 개수 리턴
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(1, 100));
    }
}
