import java.util.*;

public class 압축_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("KAKAO")));
    }

    static class Solution {
        public int[] solution(String msg) {

            Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

            for(int i = 'A'; i <= 'Z'; i++) // 알파벳 저장
                hashMap.put((char)i + "", i - 'A' + 1); // (문자열, 1~)

            char[] arr = msg.toCharArray(); // 문자배열로 변환
            int index = 1;  // 다음 단어 인덱스 관리하기위해

            StringBuilder sb = null;    // 문자열 만들기
            List<Integer> list = new ArrayList<>(); // 결과리스트

            while(index <= msg.length()) {  // 마지막 인덱스까지
                sb = new StringBuilder(arr[--index] + "");  // 처음부터 마지막 단어까지
                // 마지막 단어 이전까지 + 사전에 포함되어있으면
                while(++index < msg.length() && hashMap.containsKey(sb.toString())) // 단어 포함시켜서
                    sb.append(arr[index]);  // 문자열 만들기
                // 탈출 조건
                if(index == msg.length() && hashMap.containsKey(sb.toString())) // 마지막 단어인 경우
                    break;

                list.add(hashMap.get(sb.substring(0, sb.length() - 1)));    // 결과리스트에 값 저장
                hashMap.put(sb.toString(), hashMap.size() + 1); // 사전에 추가
            }

            list.add(hashMap.get(sb.toString()));   // 마지막 단어까지 추가

            return list.stream().mapToInt(i -> i).toArray();    // 리스트를 정수배열로 변환
        }
    }
}
