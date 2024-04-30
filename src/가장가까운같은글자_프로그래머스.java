import java.util.*;

public class 가장가까운같은글자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("banana ")));
    }

    static class Solution {
        public int[] solution(String s) {

            int[] answer = new int[s.length()]; // 결과배열
            int[] visited = new int[26];    // 방문배열, 알파벳 26개

            Arrays.fill(visited, -1);   // -1로 초기화

            char[] ch = s.toCharArray();    // 문자배열
            for(int i = 0; i < ch.length; i++) {    // 길이만큼
                if(visited[ch[i] - 'a'] == -1)  // 방문한 적이 없으면
                    answer[i] = -1; // -1
                else    // 방문한 적이 있으면
                    answer[i] = i - visited[ch[i] - 'a'];   // 앞에 나온 것과 차이

                visited[ch[i] - 'a'] = i;   // 방문배열 갱신
            }

            return answer;  // 결과배열 리턴
        }
    }
}
