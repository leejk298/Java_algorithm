import java.util.*;

public class 무인도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    static class Solution {
        int [][] iMap;
        List<Integer> res = new ArrayList<>();

        public int[] solution(String[] maps) {
            iMap = new int[maps.length][maps[0].length()];
            for(int i = 0; i < maps.length; i++) {
                char ch[] = maps[i].toCharArray();

                for(int j = 0; j < ch.length; j++) {
                    char c = ch[j];
                    if(c == 'X')
                        iMap[i][j] = -1;
                    else
                        iMap[i][j] = c - '0';
                }
            }

            for(int i = 0; i < iMap.length; i++) {
                for(int j = 0; j < iMap[0].length; j++) {
                    int isLand = dfs(i, j);
                    if(isLand > 0)
                        res.add(isLand);
                }
            }

            if(res.size() == 0)
                return new int[] {-1};

            Collections.sort(res);

            int arr[] = new int[res.size()];
            for(int i = 0; i < arr.length; i++)
                arr[i] = res.get(i);

            return arr;
        }

        public int dfs(int i, int j) {
            if(i < 0 || j < 0 || i >= iMap.length || j >= iMap[0].length)
                return 0;
            if(iMap[i][j] == -1)
                return 0;

            int tmp = iMap[i][j];
            iMap[i][j] = -1;

            return tmp + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
        }
    }
}
