import java.util.*;

public class 방문길이_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("LULLLLLLU"));
    }

    static class Solution {
        public int solution(String dirs) {
            Set<String> set = new HashSet<>();

            Pos pos = new Pos(0, 0);

            for(char c : dirs.toCharArray()) {
                String s = "";
                if(c == 'U' && pos.y < 5) {
                    pos.y++;
                    s = pos.x + ", " + (pos.y - 0.5);
                }

                if(c == 'D' && pos.y > -5) {
                    pos.y--;
                    s = pos.x + ", " + (pos.y + 0.5);
                }

                if(c == 'R' && pos.x < 5) {
                    pos.x++;
                    s = (pos.x - 0.5) + ", " + pos.y;
                }

                if(c == 'L' && pos.x > -5) {
                    pos.x--;
                    s = (pos.x + 0.5) + ", " + pos.y;
                }

                if(s != "")
                    set.add(s);
            }

            return set.size();
        }

        static class Pos {
            double x, y;

            Pos(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
