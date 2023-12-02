import java.util.*;

public class 순위검색_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]
                        {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
                                "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }
    static class Solution {
        static HashMap<String, List<Integer>> map;  // info, 해시맵

        public static int binarySearch(String key, int score) { // 이분 탐색

            List<Integer> list = map.get(key);  // 점수

            int start = 0, end = list.size() - 1;   // 시작, 끝
            while (start <= end) {  // 역전이 아니면
                int mid = (start + end) / 2;    // 중앙값

                if (list.get(mid) < score)  // 원하는 점수보다 낮으면
                    start = mid + 1;        // 시작 인덱스 갱신
                else                        // 같거나 높으면
                    end = mid - 1;          // 끝 인덱스 갱신
            }

            return list.size() - start;  // 역전이 일어나서 시작 > 끝, 해당하는 점수의 개수 리턴
        }

        public static void makeSentence(String[] p, String str, int cnt) {  // info가 포함될 수 있는 문장

            // 베이스케이스
            if (cnt == 4) { // 완성되면
                if (!map.containsKey(str)) {    // 맵에 없는지 확인
                    List<Integer> list = new ArrayList<Integer>();  // 없으면, 점수 저장할 리스트 생성
                    map.put(str, list); // 문자열과 빈리스트 저장, 정렬하기위해
                }

                map.get(str).add(Integer.parseInt(p[4]));   // 빈리스트에 해당하는 모든 점수 저장 => 정렬
                return; // 리턴
            }

            // 재귀케이스, 완성이 아니면
            makeSentence(p, str + "-", cnt + 1);    // -
            makeSentence(p, str + p[cnt], cnt + 1); // 해당 문자열 추가
        }

        public static int[] solution(String[] info, String[] query) {

            int[] answer = new int[query.length];   // 결과배열

            map = new HashMap<String, List<Integer>>(); // info 저장할 해시맵
            for (int i = 0; i < info.length; i++) {
                String[] p = info[i].split(" ");    // 공백 구분
                makeSentence(p, "", 0); // 모든 경우의 수 만들기, 백트래킹
            }

            for (String key : map.keySet()) // 해시맵 키로
                Collections.sort(map.get(key)); // 점수(밸류) 오름차순 정렬

            for (int i = 0; i < query.length; i++) {    // 쿼리 개수만큼
                query[i] = query[i].replaceAll(" and ", ""); // 문자열 바꾸기
                String[] q = query[i].split(" ");   // 공백 기준으로 나눠, 문자열과 점수로 해시맵과 같은 형태로

                answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0; // 문자열에 해당하는 점수를 이분탐색 (정렬되었으므로 가능)
            }

            return answer;  // 결과 리턴
        }
    }
}
