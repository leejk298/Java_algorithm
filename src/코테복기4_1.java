import java.util.*;
import java.io.*;

/*
5
12
12345
3333
97531
102030
 */

public class 코테복기4_1 {
    static int N;   // 크기
    static int[] arr;   // 등차수열
    static int[] dif;   // 공차배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        int count = 0;  // 총 개수
        for(int i = 0; i < N; i++) {    // 크기만큼
            boolean flag = true;    // 등차수열인지 체크
            char[] ch = bf.readLine().toCharArray();    // 문자배열로

            if(ch[0] == '-')    // 음수면 건너뛰기
                continue;

            if(ch.length < 3) { // 0 ~ 99면 등차수열로
                count++;

                continue;
            }

            arr = new int[ch.length];   // 등차수열배열
            for(int j = 0; j < arr.length; j++)
                arr[j] = ch[j] - '0';

            dif = new int[arr.length - 1];  // 공차배열
            for(int k = 0; k < dif.length; k++)
                dif[k] = arr[k + 1] - arr[k];

            for(int t = 0; t < dif.length - 1; t++) // 공차배열 비교
                if(dif[t] != dif[t + 1])    // 다르면
                    flag = false;   // false

            if(flag)    // 등차수열이면
                count++;    // 카운트
        }

        System.out.print(count);
    }
}
