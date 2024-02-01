import java.util.*;
import java.io.*;

public class 행렬곱연산횟수_DP_094 {
    static int N;
    static Matrix M[]; // 행렬
    static int D[][]; // 점화식 배열

    static class Matrix { // 클래스
        // 멤버 변수
        int row;
        int column;

        // 멤버 함수
        Matrix(int row, int column) { // 파라미터 생성자
            this.row = row;
            this.column = column;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        N = Integer.parseInt(bf.readLine()); // 개수
        M = new Matrix[N + 1]; // 초기화
        D = new int[N + 1][N + 1];

        for (int i = 0; i < D.length; i++) // 점화식 배열
            for (int j = 0; j < D[i].length; j++)
                D[i][j] = -1; // -1로 초기화

        for (int i = 1; i <= N; i++) { // 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int row = Integer.parseInt(st.nextToken()); // 행 개수
            int column = Integer.parseInt(st.nextToken()); // 열 개수

            M[i] = new Matrix(row, column); // 생성
        }
    }

    public static int execute(int s, int e) { // 최소 연산횟수

        int res = Integer.MAX_VALUE; // 최댓값으로 설정 => 최솟값 찾기위헤

        if (D[s][e] != -1) // 초기화값이 아닌경우
            return D[s][e]; // 값이 변했으므로 그대로 리턴 => 메모이제이션(다시 계산 X)

        if (s == e) // 행렬이 1개인 경우
            return 0; // 곱을 할 수 없으므로 0 리턴

        if (s + 1 == e) // 행렬이 2개인 경우
            return M[s].row * M[s].column * M[e].column; // 행렬 곱 연산

        for (int i = s; i < e; i++) // 행렬이 3개인 경우 => 재귀콜
            // i번째는 했고, (i + 1)번째 행렬을 합치는 비용을 최소로
            res = Math.min(res, M[s].row * M[i].column * M[e].column + execute(s, i) + execute(i + 1, e));

        return D[s][e] = res; // 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(execute(1, N)); // N개 행렬곱 최소 연산횟수 출력
    }
}