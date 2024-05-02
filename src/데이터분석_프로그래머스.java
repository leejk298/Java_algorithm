import java.util.*;

public class 데이터분석_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(new int[][]
                        {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                "date", 20300501, "remain")));
    }

    static class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

            Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

            hashMap.put("code", 0); // (필드값, 인덱스) 구조로 저장
            hashMap.put("date", 1);
            hashMap.put("maximum", 2);
            hashMap.put("remain", 3);

            List<int[]> list = new ArrayList<>();   // 결과리시트

            for (int[] arr : data)  // 입력배열 순회
                if (arr[hashMap.get(ext)] < val_ext)    // 기준값보다 작으면
                    list.add(arr);  // 리스트에 저장

            Collections.sort(list, (o1, o2) -> {    // 정렬
                return (o1[hashMap.get(sort_by)] - o2[hashMap.get(sort_by)]);
            }); // 정렬값 오름차순 정렬

            int[][] answer = new int[list.size()][list.get(0).length];  // 결과배열

            for (int i = 0; i < list.size(); i++)   // 리스트 크기만큼
                answer[i] = list.get(i);    // 배열 저장

            return answer;  // 결과배열 리턴
        }
    }
}
