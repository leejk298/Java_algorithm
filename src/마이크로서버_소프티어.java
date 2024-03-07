import java.util.*;
import java.io.*;


public class 마이크로서버_소프티어 {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int i = 0; i < T; i++) {
            int servers = 0;
            int count300 = 0;
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] == 300)
                    count300 += 1;
            }

            Arrays.sort(arr);

            // S: 300 이후부터
            int S = count300, E = N - 1;
            while(S <= E) { // 같은 경우 포함
                servers += 1;   // 하나는 무조건 필요

                if(arr[E] > 600) {   // 단독
                    E--;
                    continue;
                }
                else if(S != E && arr[S] + arr[E] <= 900)   // 세트
                    S++;
                else if(count300 > 0)   // 301 ~ 600
                    count300 -= 1;  // 300이랑 합쳐서 빼줌

                E--;    // 공통
            }

            // +2 한 이유는 1개라도 있으면 할당해줘야하고 3의 배수여도 문제없음
            servers += (count300 + 2) / 3;  // 300이 있으면 할당 필요

            System.out.println(servers);
        }
    }
}