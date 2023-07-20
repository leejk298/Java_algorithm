import java.io.*;
import java.util.*;

/*
3
leo
kiki
eden
eden
kiki
 */

public class 배부른마라토너_백준 {
    static int N;
    static Map<String, Integer> hashMap;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        hashMap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = bf.readLine();

            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }

        for(int i = 1; i < N; i++) {
            String str = bf.readLine();

            if(hashMap.get(str) == 1)
                hashMap.remove(str);
            else
                hashMap.put(str, hashMap.get(str) - 1);
        }

        for(String str : hashMap.keySet())
            System.out.println(str);
    }
}
