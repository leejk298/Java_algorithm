import java.util.*;
import java.io.*;

public class 선분그룹_기하_099 {
    static int parent[]; // 부모노드
    static int L[][]; // 선분 L

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 개수

        parent = new int[N + 1]; // 초기화
        for (int i = 1; i <= N; i++)
            parent[i] = -1; // 음수로 초기화 => 절대값은 그룹에 속한 선분 개수

        L = new int[N + 1][4];
        for (int i = 1; i <= N; i++) { // 초기화
            st = new StringTokenizer(bf.readLine());

            L[i][0] = Integer.parseInt(st.nextToken()); // x1
            L[i][1] = Integer.parseInt(st.nextToken()); // y1
            L[i][2] = Integer.parseInt(st.nextToken()); // x2
            L[i][3] = Integer.parseInt(st.nextToken()); // y2

            for (int j = 1; j < i; j++) // 이전에 저장된 선분들과 교차 여부 확인
                if (isCross(L[i][0], L[i][1], L[i][2], L[i][3], L[j][0], L[j][1], L[j][2], L[j][3])) // 교차이면
                    union(i, j); // 한 그룹으로 합집합
        }

        int cnt = 0, res = 0; // 그룹 개수와 그룹에 속한 최대 선분 수
        for (int i = 1; i <= N; i++) {
            if (parent[i] < 0) {
                cnt++;
                res = Math.min(res, parent[i]);
            }
        }

        System.out.println(cnt);
        System.out.println(-res);
    }

    private static int find(int i) { // find
        if (parent[i] < 0) // 음수 하나 당 그룹 하나
            return i;

        // 음수가 아니면
        return parent[i] = find(parent[i]); // 해당 부모노드로 이동
    }

    private static void union(int i, int j) { // 합집합
        int p = find(i);
        int q = find(j);

        if (p == q) // 같으면 합칠 필요 x
            return;

        // 같지 않으면
        parent[p] += parent[q]; // 한 그룹에 선분 개수 증가
        parent[q] = p; // 부모노드 갱신
    }

    private static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) { // CCW 연산
        long tmp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

        if (tmp > 0) // 양수 => 시계
            return 1;

        else if (tmp < 0) // 음수 => 반시계
            return -1;

        return 0; // 0 => 일직선
    }

    private static boolean isOverlab(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { // 겹치는 지
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
            return true;

        return false;
    }

    private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { // 교차인 지
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);

        if (abc * abd == 0 && cda * cdb == 0)
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);

        else if (abc * abd <= 0 && cda * cdb <= 0)
            return true;

        return false;
    }
}
