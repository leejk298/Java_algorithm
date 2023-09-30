import java.util.*;

public class 여행경로_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }

    static class Solution {
        static boolean[] visited;   // 방문배열
        static List<String> allRoute;   // 모든 여행 경로

        public static void DFS(int count, String b, String route, String[][] s) {   // 백트래킹
            // 베이스 케이스
            if(count == s.length) { // 전부 경유했으면
                allRoute.add(route);    // 경로 추가

                return; // 함수 리턴, 완전 탐색 위해
            }

            // 재귀 케이스
            for(int i = 0; i < s.length; i++) { // 경로배열 크기만큼
                if(b.equals(s[i][0]) && !visited[i]) {  // 출발점이 같고 방문하지 않았으면
                    visited[i] = true;  // 방문
                    DFS(count + 1, s[i][1], route + " " + s[i][1], s);  // DFS

                    visited[i] = false; // 리턴되면 해당 경로 방문 여부 갱신
                }
            }
        }

        public String[] solution(String[][] tickets) {
            // 초기화
            String[] answer;   // 결과배열
            visited = new boolean[tickets.length];  // 방문배열
            allRoute = new ArrayList<>();   // 결과리스트

            DFS(0, "ICN", "ICN", tickets);  // DFS, "ICN"부터 시작, 경로를 문자열로 관리

            Collections.sort(allRoute); // 알파벳 순으로

            answer = allRoute.get(0).split(" ");    // 공백 기준으로 나눠

            return answer;  // 결과배열 리턴
        }
    }
}
