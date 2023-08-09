import java.util.*;
import java.io.*;

/*
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face
 */

public class 패션왕_백준 {
    static int T, N;    // 크기
    static Map<String, Integer> hashMap;    // 해시맵

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        T = Integer.parseInt(bf.readLine());    // 테스트케이스 개수
        StringBuilder sb = new StringBuilder();  // 결과 문자열

        while(T-- > 0) {    // 개수만큼
            N = Integer.parseInt(bf.readLine());    // 크기
            hashMap = new HashMap<>();  // 해시맵 초기화

            for(int i = 0; i < N; i++) {    // 크기만큼
                String[] str = bf.readLine().split(" ");    // 문자열 배열

                String wear = str[1];   // 옷 종류

                hashMap.put(wear, hashMap.getOrDefault(wear, 0) + 1);   // 해시맵 저장
            }

            int count = 1;  // 곱해야 하므로 1
            for(String key : hashMap.keySet()) {    // 해시맵 순회
                int value = hashMap.get(key);   // 밸류값

                count *= value + 1;     // 안 입는 경우의 수: + 1
            }

            sb.append(count - 1 + "\n");    // 전부 다 안 입는 경우의 수는 빼줌: -1
        }

        System.out.print(sb);   // 결과 출력
    }
}
