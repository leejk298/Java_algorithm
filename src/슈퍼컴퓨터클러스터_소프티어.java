import java.util.*;
import java.io.*;


public class 슈퍼컴퓨터클러스터_소프티어 {
    static long B;
    static long A[];

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new long[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        long left = A[0];
        long right = A[N - 1] + (long)Math.sqrt(B);
        long res = -1;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(isCorrect(mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    static boolean isCorrect(long mid) {
        long max = 0;

        for(long i : A) {

            if(mid > i) {
                max += (long)Math.pow(mid - i, 2);

                if(max > B)
                    return false;
            }
        }

        return true;
    }
}