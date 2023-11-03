import java.util.*;

public class 교점에별찍기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }
    static class Solution {
        public static int startX = Integer.MAX_VALUE;   // 좌표
        public static int endX = Integer.MIN_VALUE;
        public static int startY = Integer.MAX_VALUE;
        public static int endY = Integer.MIN_VALUE;

        public String[] solution(int[][] line) {

            List<List<Integer>> list = new ArrayList<>();   // 좌표 리스트

            for(int i = 0; i < line.length - 1; i++) {  // N - 1
                for(int j = i + 1; j < line.length; j++) {  // 다음 인덱스부터
                    long a = line[i][0];
                    long b = line[i][1];
                    long e = line[i][2];
                    long c = line[j][0];
                    long d = line[j][1];
                    long f = line[j][2];

                    long denominator = (a * d) - (b * c);   // 분모
                    if(denominator == 0)    // 0 이면 건너뛰기
                        continue;

                    long numerator1 = (b * f) - (e * d);    // 분자
                    long numerator2 = (e * c) - (a * f);
                    if(numerator1 % denominator != 0 || numerator2 % denominator != 0)
                        continue;

                    int x = (int)(numerator1 / denominator);
                    int y = (int)(numerator2 / denominator);

                    List<Integer> tmp = Arrays.asList(x, y);
                    if(!list.contains(tmp))
                        list.add(tmp);

                    startX = Math.min(startX, x);   // 최소
                    endX = Math.max(endX, x);       // 최대
                    startY = Math.min(startY, y);
                    endY = Math.max(endY, y);
                }
            }

            List<String> board = new ArrayList<>(); // 문자열 리스트
            for(int i = startY; i <= endY; i++) {   // 행
                StringBuilder sb = new StringBuilder();

                for(int j = startX; j <= endX; j++)   // 열
                    sb.append(".");

                board.add(sb.toString());   // 리스트에 추가
            }

            for(List<Integer> l : list) {   // 좌표리스트 순회
                StringBuilder sb = new StringBuilder(board.get(Math.abs(l.get(1) - endY))); // 결과 문자열
                sb.setCharAt(Math.abs(l.get(0) - startX), '*'); // 별찍기
                board.set(Math.abs(l.get(1) - endY), sb.toString());
            }

            String[] answer = new String[board.size()]; // 결과 배열
            for(int i = 0; i < answer.length; i++)  // 길이만큼
                answer[i] = board.get(i);   // 저장

            return answer;  // 결과 배열 리턴
        }
    }
}
