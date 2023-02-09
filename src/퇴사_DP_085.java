import java.util.*;

public class 퇴사_DP_085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받기

        int N = sc.nextInt(); // 크기
        int T[] = new int[N + 1]; // 소요시간
        int P[] = new int[N + 1]; // 얻는비용
        int B[] = new int[N + 2]; // 총 이익

        for (int i = 1; i <= N; i++) { // 크기만큼
            T[i] = sc.nextInt(); // 시간
            P[i] = sc.nextInt(); // 비용 저장
        }

        B[N + 1] = 0; // 퇴사일은 0으로 설정 => 일하지 않으므로
        for (int i = N; i > 0; i--) { // 퇴사 전날부터 시작날까지 => 탑 다운 방식
            if (i + T[i] > N + 1) { // 해당 날에 일하여 퇴사일을 지나면
                B[i] = B[i + 1]; // 다음 날로 넘어감
            } else { // 퇴사일을 지나지않으면
                B[i] = Math.max(B[i + 1], B[i + T[i]] + P[i]); // 다음 날과 해당 날에 일한 비용의 최대값으로 설정
            }
        }

        System.out.println(B[1]); // 총 이익 출력
    }
}
