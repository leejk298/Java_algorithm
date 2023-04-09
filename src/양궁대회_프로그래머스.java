import java.util.Arrays;

public class 양궁대회_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[] {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }

    static class Solution {
        static int maxDepth;
        static int[] maxLinfo;
        static int[] aInfo;
        static int maxScoreDiff;

        public int[] solution(int n, int[] info) {
            maxDepth = n;
            aInfo = info;
            int[] lInfo = new int[11];

            DFS(0, 0, lInfo);

            return maxScoreDiff > 0 ? maxLinfo : new int[] {-1};
        }

        public static void DFS(int depth, int index, int[] lInfo) {
            if(depth == maxDepth) {
                int lScore = 0, aScore = 0;

                for(int i = 0; i < 11; i++) {
                    if(lInfo[i] > aInfo[i])
                        lScore += 10 - i;
                    else if(aInfo[i] != 0)
                        aScore += 10 - i;
                }

                int scoreDiff = lScore - aScore;

                if(scoreDiff > maxScoreDiff) {
                    maxScoreDiff = scoreDiff;
                    maxLinfo = lInfo;
                } else if(maxScoreDiff > 0 && scoreDiff == maxScoreDiff) {
                    for(int i = 10; i >= 0; i--) {
                        if(lInfo[i] > maxLinfo[i]) {
                            maxScoreDiff = scoreDiff;
                            maxLinfo = lInfo;
                        } else if(maxLinfo[i] > lInfo[i])
                            return;
                    }
                }

                return;
            }

            for(int i = index; i < 11; i++) {
                int[] nextLinfo = new int[11];

                for(int j = 0; j < 11; j++)
                    nextLinfo[j] = lInfo[j];

                if(i == 10) {
                    nextLinfo[i] += maxDepth - depth;

                    DFS(maxDepth, i, nextLinfo);
                } else if(maxDepth - depth > aInfo[i]) {
                    nextLinfo[i] += aInfo[i] + 1;

                    DFS(depth + aInfo[i] + 1, i, nextLinfo);
                }
            }
        }
    }
}
