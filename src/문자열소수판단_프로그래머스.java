import java.util.*;

public class 문자열소수판단_프로그래머스 {
    public static void main(String[] arg) {
        Solution solution = new Solution();
        solution.solution("1087");
    }

    static class Solution {
        static HashSet<Integer> set;  // 결과집합
        static ArrayList<Integer> list; // 결과리스트
        static boolean[] check;    // 방문배열

        public static void DFS(String str, String temp, int m) {    // DFS, 브루트포스

            if (temp.length() == m) {   // 같으면
                int num = Integer.parseInt(temp);   // 숫자

                if (!set.contains(num)) // 포함되어있지 않으면
                    set.add(num);   // 추가

                return; // 완전 탐색하기 위해
            }

            // 다르면
            for (int i = 0; i < str.length(); i++) {    // 길이만큼
                if (!check[i]) {    // 방문한 적이 없으면
                    check[i] = true;    // 방문
                    temp += str.charAt(i);  // 문자열 추가

                    DFS(str, temp, m);  // DFS

                    check[i] = false;   // 리턴되면 방문 여부 갱신
                    temp = temp.substring(0, temp.length() - 1);    // 문자열 갱신
                }
            }

        }

        public static boolean prime(int n) {    // 소수 판단

            if (n < 2)  // 2보다 작으면
                return false;   // 소수 x

            for (int i = 2; i * i <= n; i++)    // 제곱근만큼
                if (n % i == 0) // 나누어 떨어지면
                    return false;   // 소수 x

            return true;    // 다 만족하면 소수 o
        }

        public int solution(String numbers) {

            // 초기화
            int answer = 0;
            set = new HashSet<>();
            check = new boolean[7];

            for (int i = 0; i < numbers.length(); i++)  // 문자열 길이만큼
                DFS(numbers, "", i + 1);    // DFS

            list = new ArrayList<>(set);    // 결과리스트

            for (int i = 0; i < list.size(); i++)   // 크기만큼
                if (prime(list.get(i))) // 소수이면
                    answer++;   // 개수 카운트

            return answer;  // 결과값 리턴
        }
    }
}
