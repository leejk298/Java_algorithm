import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수_투포인터_008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 버퍼 입력받기

        int N = Integer.parseInt(bf.readLine()); // 크기, 한 줄 스트링 -> 정수로 파싱
        int A[] = new int[N]; // 배열 크기 N
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        for (int i = 0; i < N; i++) // N 만큼
            A[i] = Integer.parseInt(st.nextToken()); // 공백 기준으로 짤라서 배열에 저장, 정수로 파싱

        Arrays.sort(A); // 정렬 => quick: O(N log N) - 최선, O(N^2) - 최악

        for (int k = 0; k < N; k++) { // N 만큼
            int find = A[k]; // 찾아야할 숫자
            int i = 0, j = N - 1; // 인덱스 초기화

            while (i < j) { // 역전되면 탈출
                if (A[i] + A[j] == find) // 찾았을 때
                {
                    // 인덱스로 같은 수인지 체크 -> 이해하기
                    if (i != k && j != k) // 다른 수면
                    {
                        cnt++;
                        break;
                    }

                    else if (i == k) // 하나라도 같으면
                        i++;
                    else if (j == k)
                        j--;
                }

                else if (A[i] + A[j] < find) // 작으면 i 하나 증가 -> j를 더 키울 수 없으므로
                    i++;

                else // 크면 j 하나 감소
                    j--;
            }
        }

        System.out.println(cnt);
        bf.close();
    }
}
