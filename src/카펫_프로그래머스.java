import java.util.Arrays;

public class 카펫_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(10, 2)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {

            int[] answer = {};  // 결과배열

            int sum = brown + yellow;   // 합
            for(int i = 1; i <= sum; i++) { // 합만큼
                int row = i;    // 세로
                int col = sum / i;  // 가로

                if(row > col)   // 가로가 세로보다 길거나 같아야하므로
                    continue;   // 가로가 더 짧으면 건너뛰기

                if((row - 2) * (col - 2) == yellow) {   // 양 끝 가장자리 뺀 넓이
                    answer = new int[] {col, row};  // 결과배열에 저장

                    break;  // for 종료
                }
            }

            return answer;  // 결과배열 리턴
        }
    }
}
