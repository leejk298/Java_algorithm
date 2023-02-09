import java.io.*;

public class 수_정렬하기3_RadixSort_022 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	// 입력 버퍼
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	// 출력 버퍼

        int N = Integer.parseInt(bf.readLine());	// 크기
        int A[] = new int[N];	// 배열

        for (int i = 0; i < N; i++)	// 크기만큼
            A[i] = Integer.parseInt(bf.readLine());	// 배열 저장

        bf.close();	// 입력버퍼 닫기

        Radix_Sort(A, 5); // 자릿수 5, 10000 미만이므로

        for (int i = 0; i < N; i++)	// 크기만큼
            bw.write(A[i] + "\n");	// 출력 버퍼에 쓰기

        bw.flush();	// 버퍼에 있는 거 전부 출력
        bw.close();	// 출력버퍼 닫시
    }

    private static void Radix_Sort(int[] A, int size) {	// 기수정렬 함수: O(K * N) 성능 -> K는 자릿수
        int out[] = new int[A.length];	// 결과배열
        int t = 1;	// 연산을 위한 자릿수 1 -> 10 -> 100 -> 1000자릿수
        int cnt = 0;	// 자리수 계산

        while (cnt < size) {	// 최대 9999 -> 5자리 넘지 않음
            int bucket[] = new int[10]; // 자리수 배열

            for (int i = 0; i < A.length; i++)	// 배열 길이만큼
                bucket[(A[i] / t) % 10]++;	// 해당 자리수에 맞는 배열에 저장

            for (int i = 1; i < 10; i++)	// 각 자리 수 합 배열
                bucket[i] += bucket[i - 1];	// 자리 수에 맞춰서 정렬하기 위해

            for (int i = A.length - 1; i >= 0; i--) {	// 나중에 들어온 순으로 다시 저장
                out[bucket[(A[i] / t) % 10] - 1] = A[i];	// 결과배열에 저장
                bucket[(A[i] / t) % 10]--;	// 합 배열 값 설정
            }

            for (int i = 0; i < A.length; i++)	// 다시 들어온 순으로
                A[i] = out[i];	// 원래 배열에 옮겨 저장

            t *= 10;	// 자릿수 증가
            cnt++;	// 다음 자릿수로
        }
    }
}
