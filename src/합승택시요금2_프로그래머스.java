import java.util.*;

public class 합승택시요금2_프로그래머스 {
    public static void main(String[] args) {
        합승택시요금_프로그래머스.Solution solution = new 합승택시요금_프로그래머스.Solution();
        System.out.println(solution.solution(6, 4, 6, 2,
                new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }
    static class Solution {
        static final int MaxDistance = 200 * 10000 + 1; // 최대 길이
        public int solution(int n, int s, int a, int b, int[][] fares) {

            int[][] map = new int[n + 1][n + 1];    // 최단경로배열
            for(int i = 0; i <= n; i++) {   // 행
                for(int j = 0; j <= n; j++) {   // 열
                    if(i == j)  // 같으면
                        map[i][j] = 0;  // 0
                    else    // 다르면
                        map[i][j] = MaxDistance;    // 최대 길이로 초기화
                }
            }

            for(int i = 0; i < fares.length; i++) { // 배열 길이만큼
                int start = fares[i][0];    // 시작
                int end = fares[i][1];      // 끝
                int w = fares[i][2];        // 가중치

                map[start][end] = w;        // 무방향
                map[end][start] = w;
            }

            // 플로이드워셜 알고리즘 로직, 성능: O(V^3) => V: 노드 개수
            for (int k = 1; k <= n; k++) // 경유지 K에 대해
                for (int i = 1; i <= n; i++) // 출발노드 S에 대해
                    for (int j = 1; j <= n; j++) // 도착노드 E에 대해
                        if (map[i][j] > map[i][k] + map[k][j]) // 경유지 K를 거치는 게 작으면
                            map[i][j] = map[i][k] + map[k][j]; // 업데이트

            int answer = MaxDistance;   // 초기화
            for(int i = 1; i <= n; i++)  // 노드 개수만큼
                answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);   // 최단경로

            return answer;  // 결과 출력
        }
    }
}
