import java.util.*;

public class 광물캐기_프로그래머스 {
    static class Solution {
        static int[][] pirodo;  // 피로도
        static List<Mineral> list;  // 비용

        static class Mineral {  // 내부 클래스
            int diamond, iron, stone;

            public Mineral(int diamond, int iron, int stone) {
                this.diamond = diamond;
                this.iron = iron;
                this.stone = stone;
            }
        }

        public int solution(int[] picks, String[] minerals) {

            int answer = 0; // 결과값
            pirodo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}}; // 초기화
            list = new ArrayList<>();

            int total = 0;  // 총 개수
            for (int pick : picks)
                total += pick;

            for (int i = 0; i < minerals.length; i += 5) {  // 입력배열 길이만큼
                if (total == 0) // 곡갱이가 없으면 for - i 종료
                    break;

                int diamond = 0, iron = 0, stone = 0;   // 비용
                for (int j = i; j < i + 5; j++) {   // 5개씩
                    if (j == minerals.length)   // 모든 광물 다 캐면 for - j 종료
                        break;

                    String now = minerals[j];   // 현재 광물
                    int index = now.equals("diamond") ? 0 : now.equals("iron") ? 1 : 2; // 인덱스

                    // 드는 비용
                    diamond += pirodo[0][index];
                    iron += pirodo[1][index];
                    stone += pirodo[2][index];
                }

                list.add(new Mineral(diamond, iron, stone));    // 비용리스트에 저장
                total--;    // 곡갱이 개수 갱신
            }

            Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));  // 돌을 기준으로 내림차순 정렬 => 최고비용부터 다이아몬드 곡갱이로 캐기 위해

            for (Mineral m : list) {    // 비용리스트 순회
                int diamond = m.diamond, iron = m.iron, stone = m.stone;    // 비용

                if (picks[0] > 0) { // 다이아몬드
                    answer += diamond;
                    picks[0]--;
                } else if (picks[1] > 0) {  // 철
                    answer += iron;
                    picks[1]--;
                } else {    // 돌
                    answer += stone;
                    picks[2]--;
                }
            }

            return answer;  // 결과값 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}
