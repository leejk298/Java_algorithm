import java.util.*;

public class 제일작은수제거_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{4, 3, 2, 1})));
    }

    static class Solution {
        public int[] solution(int[] arr) {

            if (arr.length == 1)    // 길이가 1이면
                return new int[]{-1};   // -1 리턴

            int[] answer = new int[arr.length - 1]; // 결과배열
            int min = arr[0];   // 최소값

            for (int i = 1; i < arr.length; i++)    // 1부터 길이만큼
                min = Math.min(min, arr[i]);    // 최소값 갱신

            int index = 0;  // 최소값 인덱스

            for (int i = 0; i < arr.length; i++) {  // 길이만큼
                if (arr[i] == min)  // 최소값 이면
                    continue;   // 건너뛰기

                answer[index++] = arr[i];   // 결과배열 저장
            }

            return answer;  // 결과배열 리턴
        }
    }
}
