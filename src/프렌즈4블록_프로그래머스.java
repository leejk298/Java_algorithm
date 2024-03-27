import java.util.*;

public class 프렌즈4블록_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    static class Solution {
        static boolean[][] visited; // 방문배열
        static char[][] map;    // 입력배열

        public static boolean checkBlock(int i, int j, char[][] map) {  // 블록체크

            char ch = map[i][j];    // 해당 문자

            if(ch == map[i][j + 1] && ch == map[i + 1][j] && ch == map[i + 1][j + 1])   // 2 x 2
                return true;

            return false;   // 아니면 false, 변화 x
        }

        public static int shiftBlock(int m, int n, char[][] map) {  // 옮기기

            int count = 0;

            for(int i = 0; i < m; i++)  // 열
                for(int j = 0; j < n; j++)    // 행
                    if(visited[i][j])   // 방문배열이 true면, 변화 o
                        map[i][j] = '.';

            // 세로로 내리기
            for(int j = 0; j < n; j++) {    // 행 개수만큼
                Queue<Character> queue = new LinkedList<>();    // 큐, FIFO

                for(int i = m - 1; i >= 0; i--) {   // 열 개수만큼, 밑에서부터
                    if(map[i][j] == '.')    // 변화가 있으면
                        count++;    // 개수 세기
                    else    // 없으면
                        queue.add(map[i][j]);   // 큐에 삽입
                }

                int index = m - 1;  // 밑에서부터

                while(!queue.isEmpty())     // 큐가 비어있지않으면
                    map[index--][j] = queue.poll(); // 큐에서 하나씩 꺼내어 배열에 삽입

                for(int i = index; i >= 0; i--)     // 나머지는 빈칸처리
                    map[i][j] = '#';
            }

            return count;   // 개수 리턴
        }

        public int solution(int m, int n, String[] board) {

            int answer = 0;

            visited = new boolean[m][n];
            map = new char[m][n];

            for(int i = 0; i < m; i++) // 한 행씩 열 개수만큼
                map[i] = board[i].toCharArray();    // 문자열 -> 문자

            boolean flag = true;  // 반복마다 변화가 있는지 체크

            while(flag) {
                flag = false;   // 초기화

                for(int i = 0; i < m - 1; i++) {    // 열 개수
                    for(int j = 0; j < n - 1; j++) {    // 행 개수
                        if(map[i][j] == '#')    // 빈칸인 경우
                            continue;

                        if(checkBlock(i, j, map)) { // 2 x 2 블록 체크
                            visited[i][j] = true;
                            visited[i + 1][j] = true;
                            visited[i][j + 1] = true;
                            visited[i + 1][j + 1] = true;

                            flag = true;    // 변화가 있으므로 true
                        }
                    }
                }

                answer += shiftBlock(m, n, map);    // 옮길 블록수 체크
                visited = new boolean[m][n];  // 방문배열 초기화
            }

            return answer;  // 총 삭제된 블록수 리턴
        }
    }
}
