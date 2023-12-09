import java.util.Arrays;

public class 공원산책_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"SOO", "OOO", "OOO"},
                new String[] {"E 2", "S 2", "W 1"})));
    }

    static class Solution {
        static char[][] map;    // 입력배열
        static int row; // 행
        static int col; // 열
        static int[] answer;    // 결과배열

        public static int[] getNum(String str) {   // 숫자 찾기

            String[] arr = str.split(" ");  // 공백기준으로 문자열 배열로 나누기
            String op = arr[0];

            int num = Integer.parseInt(arr[1]);
            int tmpX = 0, tmpY = 0;

            switch (op) {
                case "N":
                    tmpX = answer[0] - num;
                    tmpY = answer[1];

                    break;

                case "S":
                    tmpX = answer[0] + num;
                    tmpY = answer[1];

                    break;

                case "W":
                    tmpX = answer[0];
                    tmpY = answer[1] - num;

                    break;

                case "E":
                    tmpX = answer[0];
                    tmpY = answer[1] + num;

                    break;
            }

            if (isOutOfMap(new int[]{tmpX, tmpY}) || isNotMoveable(new int[]{tmpX, tmpY}, op))
                return null;

            return new int[]{tmpX, tmpY};
        }

        public static boolean isOutOfMap(int[] pos) {  // 좌표값이 유효한지

            int r = pos[0];
            int c = pos[1];

            return r < 0 || r >= row || c < 0 || c >= col;
        }

        public static boolean isNotMoveable(int[] pos, String op) {    // 이동 가능한지

            int r = answer[0];
            int c = answer[1];
            int tmpX = pos[0];
            int tmpY = pos[1];

            switch (op) {
                case "N":
                    for (int i = 1; i <= Math.abs(tmpX - r); i++) {
                        if (map[r - i][c] == 'X') {
                            return true;
                        }
                    }
                    break;
                case "S":
                    for (int i = 1; i <= Math.abs(tmpX - r); i++) {
                        if (map[r + i][c] == 'X') {
                            return true;
                        }
                    }
                    break;
                case "W":
                    for (int i = 1; i <= Math.abs(tmpY - c); i++) {
                        if (map[r][c - i] == 'X') {
                            return true;
                        }
                    }
                    break;
                case "E":
                    for (int i = 1; i <= Math.abs(tmpY - c); i++) {
                        if (map[r][c + i] == 'X') {
                            return true;
                        }
                    }
                    break;
            }

            return false;
        }

        public int[] solution(String[] park, String[] routes) {

            // 초기화
            answer = new int[2];
            col = park[0].length();
            row = park.length;
            map = new char[row][col];

            for (int i = 0; i < park.length; i++) {  // 행
                for (int j = 0; j < park[0].length(); j++) { // 열
                    char ch = park[i].charAt(j);    // 문자
                    map[i][j] = ch; // 저장

                    if (ch == 'S') { // S이면
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }

            for (String str : routes) {  // 문자열 배열 순회
                int[] num = getNum(str);    // 숫자 배열

                if (num == null) // null
                    continue;   // 건너뛰기

                answer = num;   // 저장
            }

            return answer;  // 결과배열 리턴
        }
    }
}
