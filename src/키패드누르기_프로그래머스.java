public class 키패드누르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int l = 10, r = 12;     // 손 위치

            for(int n : numbers) {
                if(n == 1 || n == 4 || n == 7) { // 왼
                    answer += "L";
                    l = n;
                } else if(n == 3 || n == 6 || n == 9) { // 오
                    answer += "R";
                    r = n;
                } else { // 가운데
                    if(n == 0)  // 0인 경우 11로 생각
                        n = 11;
                    int left = Math.abs(n - l) / 3 + Math.abs(n - l) % 3;   // / 는 좌우, % 상하
                    int right = Math.abs(n - r) / 3 + Math.abs(n - r) % 3;

                    if(left < right) {
                        answer += "L";
                        l = n;
                    } else if(left > right) {
                        answer += "R";
                        r = n;
                    } else { // 같은 경우, 주 손
                        if(hand.equals("left")) {
                            answer += "L";
                            l = n;
                        } else {
                            answer += "R";
                            r = n;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
