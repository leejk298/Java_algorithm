import java.util.*;

public class 소수찾기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("17"));
    }

    static class Solution {
        static int answer;
        static boolean[] visited;   // 방문배열
        static List<Integer> list;  // 결과리스트

        public static void init() { // 초기화

            answer = 0; // 결과값
            visited = new boolean[7];   // 최대 7자리이므로, 소수도 7자리까지 가능
            list = new ArrayList<>();   // 결과리스트
        }

        public static void DFS(int length, String t, String s) {    // DFS

            if (length == t.length()) {  // 베이스케이스: 길이가 똑같으면
                if (!list.contains(Integer.parseInt(t))) // 결과리스트에 포함되어있지 않으면
                    list.add(Integer.parseInt(t));  // 삽입

                return;
            }

            // 재귀 케이스: 길이가 다르면
            for (int i = 0; i < s.length(); i++) {   // 입력 문자열 길이만큼
                if (!visited[i]) {   // 방문하지 않았으면
                    visited[i] = true;  // 방문
                    t += s.charAt(i);   // 새로운 문자열 만들기

                    DFS(length, t, s);  // 새로 만든 문자열로 DFS

                    visited[i] = false; // DFS 리턴되면, 해당 문자 방문 여부 갱신
                    t = t.substring(0, t.length() - 1); // 마지막에 추가된 해당 문자 제거
                }
            }
        }

        public static boolean isPrime(int n) {  // 소수 판별

            if (n < 2)   // 2보다 작으면
                return false;   // false

            // 2 이상이면
            for (int i = 2; i <= Math.sqrt(n); i++) // 제곱근까지 비교하여
                if (n % i == 0) // 하나라도 나누어 떨어지면
                    return false;   // false

            return true;    // 다 통과하면 true
        }

        public int solution(String numbers) {

            init(); // 초기화

            for (int i = 0; i < numbers.length(); i++)  // 입력 문자열 길이만큼
                DFS(i + 1, "", numbers);    // 길이 1부터 최대 길이까지, 빈 문자열 넘김

            for (int i : list)  // 결과리스트 순회하여
                if (isPrime(i)) // 하나씩 소수 판별
                    answer++;   // 소수이면 개수 카운트

            return answer;  // 개수 리턴
        }
    }
}
