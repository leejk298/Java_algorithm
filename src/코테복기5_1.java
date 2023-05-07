import java.util.*;
import java.io.*;

/*
4
12345
3333
97531
102030
 */

public class 코테복기5_1 {
    static int N;
    static int[] arr;
    static int[] dif;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = 0; i < N; i++) {
            boolean flag = true;
            char[] ch = bf.readLine().toCharArray();

            if(ch[0] == '-')
                continue;

            arr = new int[ch.length];
            for(int j = 0; j < arr.length; j++)
                arr[j] = ch[j] - '0';

            dif = new int[arr.length - 1];
            for(int k = 0; k < dif.length; k++)
                dif[k] = arr[k + 1] - arr[k];

            for(int t = 0; t < dif.length - 1; t++)
                if(dif[t] != dif[t + 1])
                    flag = false;

            if(flag)
                count++;
        }

        System.out.print(count);
    }
}
