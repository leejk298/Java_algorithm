import java.util.*;

public class 소수찾기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("17"));
    }

    static class Solution {
        public List<Integer> arr = new ArrayList<>();   // 숫자조합 저장배열, 중복 X
        public boolean[] visited = new boolean[7];      // 길이 7, 방문배열

        public int solution(String numbers) {
            int answer = 0;

            for(int i = 0; i < numbers.length(); i++)   // 숫자 조합 만들기
                DFS(numbers, "", i + 1);    // 빈 문자열과 길이로

            for(int i : arr)    // 숫자 조합 탐색
                if(isPrime(i))  // 소수이면
                    answer++;   // 개수 증가

            return answer;
        }

        public void DFS(String str, String temp, int n) {
            if(temp.length() == n) {    // 총 문자열 길이만큼 커지면
                int num = Integer.parseInt(temp);   // 정수로 바꾸고

                if(!arr.contains(num))  // 중복체크
                    arr.add(num);
            }

            // 문자열만큼 채워지지않은 경우
            for(int i = 0; i < str.length(); i++) { // 길이만큼
                if(!visited[i]) {   // 방문하지않았으면
                    visited[i] = true;  // 갱신
                    temp = temp + str.charAt(i);    // 해당 문자 붙이기

                    DFS(str, temp, n);  // 새로 갱신된 문자열 temp로 DFS
                    visited[i] = false; // 리턴되면 방문여부 갱신, 중복사용
                    temp = temp.substring(0, temp.length() - 1);    // 0번 인덱스만 남김
                }
            }
        }

        public boolean isPrime(int n) { // 소수 판단
            if(n < 2)   // 0, 1
                return false;

            for(int i = 2; i <= Math.sqrt(n); i++)  // 제곱근까지만 탐색
                if(n % i == 0)
                    return false;

            return true;
        }
    }
}
