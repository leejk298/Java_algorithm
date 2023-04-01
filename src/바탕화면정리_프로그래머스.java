import java.util.Arrays;

public class 바탕화면정리_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
    }

    static class Solution {
        public int[] solution(String[] wallpaper) {
            int lux = 51, luy = 51, rdx = 0, rdy = 0;

            for(int i = 0; i < wallpaper.length; i++) {
                String str = wallpaper[i];

                for(int j = 0; j < wallpaper[i].length(); j++) {
                    if(str.charAt(j) == '#') {
                        lux = Math.min(lux, i);
                        luy = Math.min(luy, j);
                        rdx = Math.max(rdx, i + 1);
                        rdy = Math.max(rdy, j + 1);
                    }
                }
            }

            return new int[] {lux, luy, rdx, rdy};
        }
    }
}
