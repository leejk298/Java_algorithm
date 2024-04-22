import java.util.*;

public class 문자열마음대로정렬_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {

            List<String> arr = new ArrayList<>();       // 결과리스트
            String[] answer = new String[arr.size()];   // 결과배열

            for (String s : strings) // 문자열 순회
                arr.add(s.charAt(n) + s);   // n번째 문자를 맨 앞으로 붙이기

            Collections.sort(arr);  // 오름차순 정렬

            for (int i = 0; i < arr.size(); i++) // 배열 크기만큼
                answer[i] = arr.get(i).substring(1);    // 맨 앞 문자 빼고

            return answer;  // 결과배열 리턴
        }
    }
}
