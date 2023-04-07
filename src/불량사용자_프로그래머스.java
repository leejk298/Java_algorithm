import java.util.*;

public class 불량사용자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[] {"fr*d*", "*rodo", "******", "******"}));
    }

    static class Solution {
        static Set<Set<String>> answer;
        static String[] userIds, bannedIds;

        public int solution(String[] user_id, String[] banned_id) {
            // 초기화
            userIds = user_id;
            bannedIds = banned_id;
            answer = new HashSet<>();

            DFS(0, new HashSet<>());    // 백트래킹

            return answer.size();   // 결과 리턴
        }

        public void DFS(int depth, HashSet<String> set) {
            if(depth == bannedIds.length) { // 베이스케이스, 탐색 끝나면
                answer.add(set);

                return;
            }

            // 재귀케이스
            for(int i = 0; i < userIds.length; i++) {   // 길이만큼
                if(set.contains(userIds[i]))    // 해당 문자열이 이미 있으면 건너뛰기
                    continue;

                if(checkId(userIds[i], bannedIds[depth])) { // 탐색
                    set.add(userIds[i]);    // 추가

                    DFS(depth + 1, new HashSet<>(set)); // DFS, 재귀콜
                    set.remove(userIds[i]); // 리턴되면 삭제
                }
            }
        }

        public boolean checkId(String user, String ban) {   // 체크
            if(user.length() != ban.length())   // 길이부터 다르면 다른 것
                return false;

            boolean flag = true;
            for(int i = 0; i < user.length(); i++) {
                // *가 아니고 서로 다르면 다른 것
                if(ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                    flag = false;

                    break;
                }
            }

            return flag;
        }
    }
}
