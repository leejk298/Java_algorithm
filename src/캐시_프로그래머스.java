import java.util.*;

public class 캐시_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {

            int answer = 0; // 결과값
            List<String> list = new LinkedList<>(); // 연결리스트 구현

            if (cacheSize == 0)  // 크기가 0이면
                return cities.length * 5;

            // 크기가 0이 아니면
            for (int i = 0; i < cities.length; i++) {    // 길이만큼
                String str = cities[i].toUpperCase();   // 대문자로

                if (list.remove(str)) {  // 제거할 수 있으면
                    answer += 1;    // 결과값 갱신
                    list.add(str);  // 추가
                } else {    // 없으면
                    answer += 5;    // 갱신

                    if (list.size() >= cacheSize)    // 리스트의 크기가 캐시 크기보다 크거나 같으면
                        list.remove(0); // 첫 번째 문자열 제거

                    list.add(str);  // 해당 문자열 추가
                }
            }

            return answer;  // 결과값 리턴
        }
    }
}
