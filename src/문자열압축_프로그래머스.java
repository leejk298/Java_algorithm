public class 문자열압축_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcabcabcabcdededededede"));
    }

    static class Solution {
        public int solution(String s) {

            int answer = s.length();    // 최초 길이로 초기화
            int count = 1;  // 자신 포함
            StringBuilder sb = new StringBuilder(); // 문자열 만들기

            for (int i = 1; i <= s.length() / 2; i++) {  // 절반만 비교
                String first = s.substring(0, i);   // 압축 레벨만큼, 비교할 문자열

                for (int j = i; j <= s.length(); j += i) {  // 비교될 문자열
                    int endIndex = Math.min(i + j, s.length()); // 끝 인덱스
                    String second = s.substring(j, endIndex);

                    if (first.equals(second))    // 같으면 카운트세기
                        count++;
                    else {  // 다르면
                        if (count >= 2)    // 이전에 같았으면
                            sb.append(count);   // 같은 개수만큼 문자열에 추가

                        sb.append(first);   // 비교할 문자열 추가
                        first = second;     // 비교할 문자열 갱신
                        count = 1;          // 카운트 초기화
                    }
                }

                sb.append(first);   // 나머지 문자열 추가
                answer = Math.min(answer, sb.length()); // 최소값 구하기
            }

            return answer;
        }
    }
}
