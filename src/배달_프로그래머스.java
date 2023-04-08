public class 배달_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][] {{1, 2, 1}, {2, 3, 3},
                {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }

    static class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int[][] map = new int[N][N];    // 인접행렬

            // 초기화, 최대값으로
            for(int i = 0; i < N; i++) {    // 노드 개수만큼
                for(int j = 0; j < N; j++) {
                    if(i == j)  // 같은 도시
                        continue;
                    // 다른 도시
                    map[i][j] = 500001;
                }
            }

            for(int[] a : road) {
                int S = a[0] - 1;   // 시작
                int E = a[1] - 1;   // 도착
                int W = a[2];       // 거리

                if(map[S][E] > W) {
                    map[S][E] = W;
                    map[E][S] = W;
                }
            }

            for(int k = 0; k < N; k++)
                for(int i = 0; i < N; i++)
                    for(int j = 0; j < N; j++)
                        if(map[i][j] > map[i][k] + map[k][j])
                            map[i][j] = map[i][k] + map[k][j];


            for(int i = 0; i < N; i++)
                if(map[0][i] <= K)
                    answer++;

            return answer;
        }
    }
}
