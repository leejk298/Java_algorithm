import java.util.Arrays;

public class 공원산책_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"SOO", "OOO", "OOO"},
                new String[] {"E 2", "S 2", "W 1"})));
    }

    static class Solution {
        static char[][] map;
        static int row;
        static int col;
        static int[] answer;

        public int[] solution(String[] park, String[] routes) {

            answer = new int[2];

            col = park[0].length();
            row = park.length;

            map = new char[row][col];
            for(int i = 0; i < park.length; i++) {
                for(int j = 0; j < park[0].length(); j++) {
                    char ch = park[i].charAt(j);
                    map[i][j] = ch;

                    if(ch == 'S') {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }

            for(String str : routes) {
                int[] num = getNum(str);

                if(num == null)
                    continue;

                answer = num;
            }

            return answer;
        }

        static int[] getNum(String str) {

            String[] arr = str.split(" ");
            String op = arr[0];

            int num = Integer.parseInt(arr[1]);
            int tmpX = 0, tmpY = 0;

            switch(op) {
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

            if(isOutOfMap(new int[] {tmpX, tmpY}) || isNotMoveable(new int[] {tmpX, tmpY}, op))
                return null;

            return new int[] {tmpX, tmpY};
        }

        static boolean isOutOfMap(int[] pos) {

            int r = pos[0];
            int c = pos[1];

            return r < 0 || r >= row || c < 0 || c >= col;
        }

        static boolean isNotMoveable(int[] pos, String op) {

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
    }
}
