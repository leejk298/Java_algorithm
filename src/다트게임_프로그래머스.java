public class 다트게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1D2S#10S"));
    }

    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int[] arr = new int[3]; // 결과 배열

            int num = 0, index = 0;   // 숫자, 배열 인덱스
            String str = "";    // 문자열

            for(int i = 0; i < dartResult.length(); i++) {
                char ch = dartResult.charAt(i); // 문자열 하나씩 문자로

                if(ch - '0' >= 0 && ch - '0' <= 9) {    // 숫자이면
                    str += String.valueOf(ch);  // 10도 가능하므로 문자열로

                } else if(ch == 'S' || ch == 'D' || ch == 'T') {    // 보너스
                    num = Integer.parseInt(str);    // 문자열을 숫자로

                    if(ch == 'S')
                        arr[index++] = (int)Math.pow(num, 1);

                    if(ch == 'D')
                        arr[index++] = (int)Math.pow(num, 2);

                    if(ch == 'T')
                        arr[index++] = (int)Math.pow(num, 3);

                    str = "";   // 문자열 초기화
                    
                } else {    // 옵션
                    if(ch == '*') {
                        arr[index - 1] *= 2;

                        if(index >= 2)  // 중첩 가능
                            arr[index - 2] *= 2;
                    } else {
                        arr[index - 1] *= -1;
                    }
                }
            }

            for(int i = 0; i < arr.length; i++) // 합
                answer += arr[i];

            return answer;  // 결과 출력
        }
    }
}
