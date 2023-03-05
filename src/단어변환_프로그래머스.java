public class 단어변환_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog",
                new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    static class Solution {
        static boolean[] visited;   // 방문배열
        static int answer;  // 변환 횟수

        public int solution(String begin, String target, String[] words) {
            answer = 0; // 초기화

            boolean flag = false;
            for(String s : words)
                if(s.equals(target))    // 변환가능한지
                    flag = true;

            if(!flag)   // 변환 X
                return 0;

            // 변환 O
            visited = new boolean[words.length];

            DFS(begin, target, words, 0);   // DFS

            return answer;
        }

        static void DFS(String b, String t, String[] w, int res) {
            if(b.equals(t)) {   // 베이스 케이스
                answer = res;   // 횟수 저장

                return;
            }

            for(int i = 0; i < w.length; i++) { // 배열 크기만큼
                if(!visited[i]) {   // 방문하지않았으면
                    int count = 0;  // 횟수

                    for(int j = 0; j < b.length(); j++) // 문자열 길이만큼
                        if(w[i].charAt(j) == b.charAt(j))   // 같은 문자 카운트
                            count++;

                    if(count == b.length() - 1) {   // 하나 빼고 다 같으면
                        visited[i] = true;  // 해당 문자열로 DFS
                        DFS(w[i], t, w, res + 1);   // 재귀

                        visited[i] = false; // 재귀함수 리턴되면 방문배열 초기화
                    }
                }
            }
        }
    }
}
