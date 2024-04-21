import java.util.*;
import java.io.*;

/*
5 2
map
set
dijkstra
floyd
os
map,dijkstra
map,floyd
 */

public class 가희와키워드_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 키워드 개수
        int M = Integer.parseInt(st.nextToken());   // 쓴 글 개수

        Map<String, Boolean> hashMap = new HashMap<>(); // 해시맵
        for (int i = 0; i < N; i++) // 키워드 개수만큼
            hashMap.put(bf.readLine(), true);   // 해시맵 저장

        StringBuilder sb = new StringBuilder(); // 결과문자열

        for (int i = 0; i < M; i++) {   // 쓴 글 개수만큼
            String[] str = bf.readLine().split(",");    // , 기준으로 문자열 나누기

            for (String key : str) {    // 배열 순회
                if (hashMap.containsKey(key) && hashMap.get(key)) { // key 값 존재 + value 값 true
                    hashMap.put(key, false);    // 해당 key 값의 value 값 false 갱신
                    N--;    // 개수 카운트
                }
            }

            sb.append(N + "\n");    // 결과문자열에 개수 추가
        }

        System.out.print(sb);   // 결과 출력
    }
}
