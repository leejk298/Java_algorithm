import java.util.*;

/*
2 5
80 100
90 110
70
80
90
100
120
 */
public class 코테복기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] s = new int[N];
        int[] f = new int[N];
        for(int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
            f[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();

            int count = 0;
            for(int j = 0; j < N; j++) {
                int start = s[j], finish = f[j];

                if(num >= start && num <= finish)
                    count++;
                else
                    break;
            }

            if(count == N)
                sum++;
        }

        System.out.print(sum);
    }
}
