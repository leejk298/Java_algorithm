import java.util.*;
import java.io.*;

/*
7
1110111
0110101
0110101
0000100
0110000
0111110
0110000
*/

public class 장애물인식_소프티어 {
    static int N, sNum;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] map;
    static List<List<int []>> sumList;
    static List<int[]> mList;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            char[] ch = str.toCharArray();

            for(int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        visited = new boolean[N][N];
        sNum = 1;
        sumList = new ArrayList<List<int []>>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList);
                }
            }
        }

        sumList.sort((List<int[]> o1, List<int[]> o2) -> o1.size() - o2.size());

        System.out.println(sumList.size());

        for(int i = 0; i < sumList.size(); i++)
            System.out.println(sumList.get(i).size());
    }

    static void BFS(int i, int j) {
        Queue<int []> queue = new LinkedList<>();
        mList = new ArrayList<int []>();

        mList.add(new int[] {i, j});
        queue.offer(new int[] {i, j});

        map[i][j] = sNum;
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int k = 0; k < 4; k++) {
                int tmpX = dx[k];
                int tmpY = dy[k];

                while(x + tmpX >= 0 && x + tmpX < N && y + tmpY >= 0 && y + tmpY < N) {
                    if(map[x + tmpX][y + tmpY] != 0 && !visited[x + tmpX][y + tmpY]) {
                        addNode(x + tmpX, y + tmpY, queue);
                    } else
                        break;
                }

                if(tmpX > 0)
                    tmpX++;
                if(tmpX < 0)
                    tmpX--;
                if(tmpY > 0)
                    tmpY++;
                if(tmpY < 0)
                    tmpY--;
            }
        }
    }

    static void addNode(int i, int j, Queue<int []> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;

        mList.add(new int[] {i, j});
        queue.offer(new int[] {i, j});
    }
}