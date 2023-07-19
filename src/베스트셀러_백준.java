import java.io.*;
import java.util.*;

/*
5
top
top
top
top
kimtop
 */

public class 베스트셀러_백준 {
    static int N;   // 크기
    static Map<String, Integer> hashMap;    // 해시맵

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        hashMap = new HashMap<>();
        for(int i = 0; i < N; i++) {    // 크기만큼
            String str = bf.readLine(); // 한 줄 스트링

            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1); // 해시맵 저장
        }
    }

    public static void printMaxCount() {    // 최대 개수 출력

        int max = 0;    // 최대값

        for(String key : hashMap.keySet()) {    // 해시맵 순회
            int count = hashMap.get(key);   // 밸류
            if(max < count) // 최대값 찾기
                max = count;
        }

        List<String> list = new ArrayList<>();  // 결과리스트
        for(String key : hashMap.keySet()) {    // 해시맵 순회
            int count = hashMap.get(key);   // 밸류
            if(max == count)    // 최대값이면
                list.add(key);  // 리스트에 저장
        }

        Collections.sort(list); // 알파벳 순으로 오름차순 정렬

        System.out.println(list.get(0));    // 제일 앞에 있는 값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printMaxCount();    // 최대 개수 출력
    }
}
