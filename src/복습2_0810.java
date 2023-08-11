import java.util.*;

public class 복습2_0810 {
    static class Solution {
        static char[] ch;   // 결과 문자배열

        public static void change(int a, int b) {   // 변환

            for(int i = a; i <= (a + b) / 2; i++) { // 절반만큼
                char tmp = ch[i];   // 스왑
                ch[i] = ch[a + b - i];
                ch[a + b - i] = tmp;
            }
        }

        public String solution(String S, int[][] interval) {

            ch = S.toCharArray();   // 문자배열로 변환

            for(int[] in : interval)    // 입력배열 순회
                change(in[0] - 1, in[1] - 1);   // 인덱스로 변환

            return new String(ch);  // 문자열로 변환
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution("abcde", new int[][] {{1, 4}, {1, 5}, {2, 3}, {3, 4}, {3, 3}}));
    }
}
