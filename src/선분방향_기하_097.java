import java.util.*;

public class 선분방향_기하_097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int x[] = new int[3]; // x1, x2, x3
        int y[] = new int[3]; // y1, y2, y3

        for (int i = 0; i < 3; i++) { // 점 3개
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // ccw 결과: 공식
        int ccw = (x[0] * y[1] + x[1] * y[2] + x[2] * y[0]) - (x[1] * y[0] + x[2] * y[1] + x[0] * y[2]);

        if (ccw < 0) // 음수면 반시계
            System.out.println(-1);
        else if (ccw > 0) // 양수면 시계
            System.out.println(1);
        else // 0이면 일직선
            System.out.println(0);
    }
}
