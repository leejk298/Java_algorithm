import java.util.*;

public class 롤케이크자르기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    static class Solution {
        public int solution(int[] topping) {

            int answer = 0; // 개수
            int len = topping.length;   // 길이

            HashSet<Integer> type = new HashSet<>();    // 종류
            HashMap<Integer, Integer> count = new HashMap<>();  // 종류 당 개수

            // 값 세팅
            for (int i = 0; i < len; i++)    // 길이만큼
                count.put(topping[i], count.getOrDefault(topping[i], 0) + 1);   // 없으면 생성 후 해시맵 저장

            // 처리
            for (int i = 0; i < len; i++) {  // 길이만큼
                type.add(topping[i]);   // 종류 세기

                if (count.get(topping[i]) == 1)   // 해당 종류가 1개면 해당 인덱스 제거
                    count.remove(topping[i]);
                else    // 1개 보다 많으면
                    count.put(topping[i], count.get(topping[i]) - 1);   // value: - 1

                if (type.size() == count.size()) // 종류의 개수 같으면
                    answer++;   // 가능
                if (type.size() > count.size())  // 집합에 저장한 종류수가 많으면 더이상 탐색 X
                    break;
            }

            return answer;  // 개수 리턴
        }
    }
}
