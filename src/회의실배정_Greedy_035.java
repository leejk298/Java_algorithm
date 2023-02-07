import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정_Greedy_035 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 크기
        int A[][] = new int[N][2];	// 2차원 배열

        for (int i = 0; i < N; i++) {	// 크기 만큼
            A[i][0] = sc.nextInt();	// 시작 시간
            A[i][1] = sc.nextInt();	// 종료 시간
        }

        Arrays.sort(A, new Comparator<int[]>() {	// 종료 시간에 대해 오름차순, 같으면 시작 시간에 대해 오름차순 정렬

            @Override
            public int compare(int[] S, int[] E) {	// 재정의

                if (S[1] == E[1])	// 종료 시간이 같으면
                    return S[0] - E[0];	// 시작 시간에 대해 오름차순

                return S[1] - E[1];	// 종료 시간이 다르면 종료 시간에 대해 오름차순
            }
        });

        int cnt = 0, end = -1;	// 이용가능횟수, 종료 시간

        for (int i = 0; i < N; i++) {	// 크기 만큼
            if (A[i][0] >= end) {	// 이용시간이 겹치지 않으면
                end = A[i][1];	// 종료 시간 설정
                cnt++;	// 이용횟수 카운트
            }
        }

        System.out.println(cnt);	// 출력
    }
}
