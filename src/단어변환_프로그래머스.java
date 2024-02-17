public class 단어변환_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog",
                new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    static class Solution {
        static int answer;  // 결과값, 백트래킹 후 저장해야 하므로 전역
        static boolean[] visited;   // 방문배열
        public static void DFS(int depth, String b, String t, String[] w) { // 백트래킹

            if(b.equals(t)) {   // 베이스케이스: 같으면
                answer = Math.min(answer, depth);   // 최소값 저장

                return; // 함수 리턴, 완전 탐색 위해
            }

            // 재귀 케이스: 같지 않으면
            for(int i = 0; i < w.length; i++) { // 문자열 크기만큼

                if(!visited[i]) {   // 방문한 적이 없으면
                    int count = 0;  // 개수 카운트

                    for(int j = 0; j < b.length(); j++) // 해당 문자열 길이만큼
                        if(w[i].charAt(j) == b.charAt(j))   // 전부 비교
                            count++;    // 개수 카운트

                    if(count == b.length() - 1) {   // 1개 말고 전부 같으면
                        visited[i] = true;  // 해당 문자 방문
                        DFS(depth + 1, w[i], t, w); // DFS

                        visited[i] = false; // 리턴되면 다시 false, 방문 여부 갱신
                    }
                }
            }
        }

        public int solution(String begin, String target, String[] words) {

            answer = Integer.MAX_VALUE; // 최대값으로 초기화, 최소값 찾아야하므로
            boolean flag = false;   // 비교하기 위해

            for(String w : words)   // 입력 배열 순회
                if(w.equals(target))    // 같은게 있으면
                    flag = true;    // true

            if(!flag)   // 없으면
                return 0;   // 갈 수 없으므로 0 리턴

            // true 인 경우
            visited = new boolean[words.length];    // 방문배열 선언
            DFS(0, begin, target, words);   // DFS

            return answer;  // 최소 변환 횟수 출력
        }
    }
}
