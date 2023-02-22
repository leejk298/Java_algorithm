import java.util.*;
import java.io.*;


public class 비밀메뉴1_소프티어 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        StringBuilder check = new StringBuilder();
        for(int i = 0; i < N; i++)
            check.append(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        StringBuilder arr = new StringBuilder();
        for(int i = 0; i < M; i++)
            arr.append(st.nextToken());

        if(check.length() > arr.length())
            System.out.println("normal");
        else {
            if(arr.toString().contains(check.toString()))
                System.out.println("secret");
            else
                System.out.println("normal");
        }
    }
}