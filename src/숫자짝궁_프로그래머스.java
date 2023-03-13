public class 숫자짝궁_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("12321", "42531"));
    }

    static class Solution {
        public String solution(String X, String Y) {
            StringBuilder sb = new StringBuilder();

            int[] arrX = new int[10];
            int[] arrY = new int[10];

            digitSameIndex(X, arrX);
            digitSameIndex(Y, arrY);

            for(int i = 9; i >= 0; i--) {   // 역순 출력
                while(arrX[i] > 0 && arrY[i] > 0) {
                    arrX[i]--;
                    arrY[i]--;

                    sb.append(i);
                }
            }

            if(sb.toString().equals(""))
                return "-1";
            else if(sb.toString().startsWith("0"))
                return "0";
            else
                return sb.toString();
        }

        public void digitSameIndex(String s, int[] arr) {
            for(int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                arr[digit]++;
            }
        }
    }
}
