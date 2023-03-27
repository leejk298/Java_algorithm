public class 삼총사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {-2, 3, 0, 2, -5}));
    }

    static class Solution {
        public int solution(int[] number) {
            int answer = 0;

            for(int i = 0; i < number.length - 2; i++) {
                for(int j = i + 1; j < number.length - 1; j++) {
                    int index = number.length - 1;

                    while(j < index) {
                        if(number[i] + number[j] + number[index] == 0) {
                            answer++;
                        }

                        index--;
                    }
                }
            }

            return answer;
        }
    }
}
