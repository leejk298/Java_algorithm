import java.util.Arrays;

public class 로또순위_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {44, 1, 0, 0, 31, 25},
                new int[] {31, 10, 45, 1, 6, 19})));
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            int count0 = 0, check = 0;
            for(int i = 0; i < lottos.length; i++) {
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == 0) {
                        count0++;
                        break;
                    } else if(lottos[i] == win_nums[j]) {
                        check++;
                        break;
                    }
                }
            }

            if(check == 6) {
                answer[1] = 1;
            } else if(check == 5) {
                answer[1] = 2;
            } else if(check == 4) {
                answer[1] = 3;
            } else if(check == 3) {
                answer[1] = 4;
            } else if(check == 2) {
                answer[1] = 5;
            } else
                answer[1] = 6;

            answer[0] = answer[1] - count0;

            if(count0 == 6) {
                answer[0] = 1;
                answer[1] = 6;
            }

            return answer;
        }
    }
}
