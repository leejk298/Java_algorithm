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

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기

        Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

        for (int i = 0; i < N; i++) {   // 크기만큼
            String str = bf.readLine(); // 문자열

            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1); // 해시맵 구현
        }

        for (int i = 1; i < N; i++) {   // 1 ~ N
            String str = bf.readLine(); // 문자열

            if (hashMap.get(str) == 1)  // 하나만 있으면
                hashMap.remove(str);    // 삭제
            else    // 하나 초과이면
                hashMap.put(str, hashMap.get(str) - 1); //  하나 줄이기
        }

        for (String str : hashMap.keySet()) // 키값
            System.out.println(str);    // 출력
    }
}
