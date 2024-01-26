import java.util.*;

public class 데이터분석_프로그래머스 {
    static class Solution {

        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

            Map<String, Integer> hashMap = new HashMap<>(); // 해시맵
            // 정렬기준을 키값으로 하고, 인덱스를 밸류값으로 설정
            hashMap.put("code", 0);
            hashMap.put("date", 1);
            hashMap.put("maximum", 2);
            hashMap.put("remain", 3);

            int[][] answer = Arrays.stream(data).filter(arr -> arr[hashMap.get(ext)] < val_ext).toArray(int[][]::new);
            // 해시맵에서 ext에 해당하는 인덱스를 가져와서 그 값으로 필터링 후 2차원 배열로 저장

            Arrays.sort(answer, (o1, o2) -> o1[hashMap.get(sort_by)] - o2[hashMap.get(sort_by)]);
            // 해시맵에서 정렬기준에 해당하는 인덱스를 가져와서 그 값으로 오름차순 정렬

            return answer;  // 배열 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(new int[][]
                        {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                "date", 20300501, "remain")));
    }
}
