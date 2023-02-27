public class 조이스틱_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("JEROEN"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int count = name.length() - 1; // 오른쪽으로만 이동

            for(int i = 0; i < name.length(); i++) {
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 조이스틱 상하

                // 조이스틱 좌우
                if(i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                    int endA = i + 1;   // 시작 A 값

                    while(endA < name.length() && name.charAt(endA) == 'A')
                        endA++; // 마지막 A 값

                    count = Math.min(count, i * 2 + (name.length() - endA)); // 오-왼
                    count = Math.min(count, i + (name.length() - endA) * 2); // 왼-오
                }
            }

            return answer + count;
        }
    }
}
