import java.util.*;
import java.io.*;

/*
3
deed
mean
demeaned
 */

public class 복습2번_2 { // 성능 최적화 방법
    static int N;   // 크기
    static String[] st; // 입력 배열
    static Map<String, Integer> hashMap;    // 해시맵

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        st = new String[N];
        for(int i = 0; i < N; i++)
            st[i] = bf.readLine();
    }

    public static void addHashMap() {    // 해시맵 추가

        hashMap = new HashMap<>();  // 해시맵 초기화

        for(int i = 0; i < N; i++) {    // 크기만큼
            String str = st[i]; // 문자열 하나씩
            int len = st[i].length();   // 길이

            for(int k = 1; k < len; k++) {  // 양 끝을 제외한 가운데 인덱스에 문자열 삽입
                String tmp = null;  // 저장할 문자열

                for(int j = 0; j < N; j++) {    // 크기만큼
                    tmp = str.substring(0, k) + st[j] + str.substring(k, len);  // 가운데에 하나씩 붙이기
                    hashMap.put(tmp, 1);    // 문자열을 키값으로 하는 해시맵 저장
                }
            }
        }
    }

    public static void printCount() {   // 개수 출력

        int count = 0;  // 개수

        for(int i = 0; i < N; i++) {    // 문자열 크기만큼
            if(hashMap.containsKey(st[i]))  // 하나씩 해시맵에 존재하는지
                count += hashMap.get(st[i]);    // 존재하면 벨류값인 1씩 더해줌, 개수 카운트
        }

        System.out.println(count);  // 총 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화, O(N)

        addHashMap();   // 해시맵 추가, O(N^2 * len - 1) => O(N^2), len: 문자열 길이

        printCount();   // 개수 출력, O(N) => containsKey()는 O(1) 성능이므로 최적화 가능
    }
}
