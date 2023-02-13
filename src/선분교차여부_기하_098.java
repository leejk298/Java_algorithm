import java.util.*;

public class 선분교차여부_기하_098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int x[] = new int[4]; // 선분L1(A, B), 선분L2(C, D)의 x좌표
        int y[] = new int[4]; // 선분L1(A, B), 선분L2(C, D)의 y좌표

        for (int i = 0; i < 4; i++) { // 점 4개
            x[i] = sc.nextInt(); // 좌표 저장
            y[i] = sc.nextInt();
        }

        if (isCross(x, y)) // 교차이면 1 출력
            System.out.println(1);
        else // 아니면 0 출력
            System.out.println(0);

    }

    private static boolean isCross(int[] x, int[] y) { // 교차인지
        int ccw[] = new int[4]; // ABC, ABD, CDA, CDB

        ccw[0] = x[0] * y[1] + x[1] * y[2] + x[2] * y[0] - (x[1] * y[0] + x[2] * y[1] + x[0] * y[2]); // ABC
        ccw[1] = x[0] * y[1] + x[1] * y[3] + x[3] * y[0] - (x[1] * y[0] + x[3] * y[1] + x[0] * y[3]); // ABD
        ccw[2] = x[2] * y[3] + x[3] * y[0] + x[0] * y[2] - (x[3] * y[2] + x[0] * y[3] + x[2] * y[0]); // CDA
        ccw[3] = x[2] * y[3] + x[3] * y[1] + x[1] * y[2] - (x[3] * y[2] + x[1] * y[3] + x[2] * y[1]); // CDB

        if ((ccw[0] * ccw[1] == 0) && (ccw[2] * ccw[3] == 0)) // (ABC x ABD == 0) && (CDA x CDB == 0) 이면
            return (isOverlab(x, y)); // 겹치는 지 아닌지

        else if ((ccw[0] * ccw[1] <= 0) && (ccw[2] * ccw[3] <= 0)) // 교차하려면 곱이 음수 => 방향이 반대
            return true;

        return false;
    }

    private static boolean isOverlab(int[] x, int[] y) { // 겹치는 지
        // 한 선분의 한 점의 max값이 다른 선분의 한 점의 min값보다 작으면 겹침
        if (Math.min(x[0], x[1]) <= Math.max(x[2], x[3]) && Math.min(x[2], x[3]) <= Math.max(x[0], x[1])
                && Math.min(y[0], y[1]) <= Math.max(y[2], y[3]) && Math.min(y[2], y[3]) <= Math.max(y[0], y[1]))
            return true;

        return false;
    }

}
