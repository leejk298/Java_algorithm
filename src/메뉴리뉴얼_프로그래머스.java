import java.util.*;

public class 메뉴리뉴얼_프로그래머스 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(orders, course)));
    }

    static class Solution {
        private static Map<String, Integer> hashMap = new HashMap<>();  // 코스요리
        private static List<String> list = new ArrayList<>();    // 결과리스트

        public String[] solution(String[] orders, int[] course) {
            for(int i = 0; i < orders.length; i++) {    // 문자열 하나씩
                char[] ch = orders[i].toCharArray();    // 문자로 바꿔서 정렬
                Arrays.sort(ch);
                orders[i] = String.valueOf(ch);         // 다시 문자열로
            }

            for(int i = 0; i < course.length; i++) {    // 길이만큼
                for(int j = 0; j < orders.length; j++) {  // 주문
                    combination("", orders[j], course[i]);  // 코스요리 조합
                }

                if(!hashMap.isEmpty()) {    // 비어있지 않으면
                    List<Integer> countList = new ArrayList<>(hashMap.values());    // value 값으로 리스트

                    int max = Collections.max(countList);   // 가장 큰 값
                    if(max >= 2) {  // 2이상
                        for(String s : hashMap.keySet()) {  // 찾기
                            if(hashMap.get(s) == max)
                                list.add(s);    // 결과리스트에 저장
                        }
                    }

                    hashMap.clear();    // 초기화
                }
            }

            Collections.sort(list); // 오름차순 정렬

            return list.toArray(new String[list.size()]);   // 배열로 리턴
        }

        public static void combination(String s, String str, int count) {   // 조합
            if(count == 0) {    // 베이스 케이스
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);     // 코스요리 저장

                return; // 다시 for 로
            }

            for(int i = 0; i < str.length(); i++) { // 문자열 길이만큼
                combination(s + str.charAt(i), str.substring(i + 1), count - 1);    // 재귀콜
            }
        }
    }
}
