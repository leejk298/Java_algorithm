public class 큰수만들기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1924", 2));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();

            int index = 0;
            // k개 만큼 제거한 개수만큼 뽑음, i: 뽑을 개수
            for(int i = 0; i < number.length() - k; i++) {
                int max = 0;
                // 순서 고려, j: 구간 중 가장 큰 수
                for(int j = index; j <= k + i; j++) {
                    if(max < number.charAt(j) - '0') {
                        max = number.charAt(j) - '0';
                        index = j + 1;
                    }
                }

                sb.append(max); // 가장 큰 수 추가
            }

            return sb.toString();   // 문자열 변환
        }
    }
}
