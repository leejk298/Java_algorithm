import java.util.*;

public class 사칙연산_DP_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
    }

    static class Solution {
        static int[][] min, max;    // 최소, 최대값 배열

        public static void findMinAndMax(int a, int b, int i, int j, boolean flag) {    // 최소, 최대값 찾기

            if(flag && a < 0) { // true 이고 a가 음수이면
                min[i][j] = Math.min(min[i][j], Math.min(a - b, a + b));    // 최소값 갱신
                max[i][j] = Math.max(max[i][j], Math.max(a - b, a + b));    // 최대값 갱신
            } else {    // false 이거나 a가 0보다 크면
                min[i][j] = Math.min(min[i][j], a + b);
                max[i][j] = Math.max(max[i][j], a + b);
            }
        }

        public int solution(String arr[]) {

            int len = arr.length / 2 + 1; // 숫자 개수

            min = new int[len][len];    // 최소값 배열 초기화
            max = new int[len][len];    // 최대값
            int[] temp = new int[len];  // 임시배열

            for(int i = 0; i < arr.length; i += 2) {    // 입력배열 길이만큼
                int num = Integer.parseInt(arr[i]); // 해당 숫자

                if(i == 0)  // 처음
                    temp[i / 2] = num;  // 무조건 숫자
                else    // 나머지
                    temp[i / 2] = arr[i - 1].equals("+") ? num : -num;  // 부호 붙여서
            }

            for(int i = len - 1; i >= 0; i--) { // 뒤에서부터
                for(int j = i; j < len; j++) {  // 차례로
                    if(i == j) {    // 같으면
                        min[i][j] = temp[i];
                        max[i][j] = temp[i];
                    } else {    // 다르면
                        min[i][j] = Integer.MAX_VALUE;
                        max[i][j] = Integer.MIN_VALUE;

                        for(int k = i; k < j; k++) {
                            boolean flag = k == i ? true : false;

                            // 4가지 경우
                            findMinAndMax(min[i][k], min[k + 1][j], i, j, flag);
                            findMinAndMax(min[i][k], max[k + 1][j], i, j, flag);
                            findMinAndMax(max[i][k], min[k + 1][j], i, j, flag);
                            findMinAndMax(max[i][k], max[k + 1][j], i, j, flag);
                        }
                    }
                }
            }

            return max[0][len - 1]; // 최대값 리턴
        }
    }
}
