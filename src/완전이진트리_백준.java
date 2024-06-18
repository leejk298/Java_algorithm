import java.util.*;
import java.io.*;

/*
3
1 6 4 3 5 2 7
 */

public class 완전이진트리_백준 {
    static int[] node;  // 입력배열
    static List<Integer>[] A;   // 트리

    public static void TreeSearch(int s, int e, int depth) {    // 트리 검색 -> 중위순회(자 -> 왼 -> 오)

        if (s > e)  // 베이스케이스: s가 더 크면
            return; // 건너띄기

        // 재귀케이스: e가 크거나 같으면
        int mid = (s + e) / 2;  // 중앙값

        A[depth].add(node[mid]);    // 자
        TreeSearch(s, mid - 1, depth + 1);  // 왼
        TreeSearch(mid + 1, e, depth + 1);  // 오
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기
        int size = (int) Math.pow(2, N) - 1;    // 개수
        node = new int[size];   // 입력배열

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for (int i = 0; i < size; i++)  // 개수만큼
            node[i] = Integer.parseInt(st.nextToken()); // 배열 저장

        int h = (int) Math.ceil(Math.log(size) / Math.log(2)) + 1;  // 높이
        A = new List[h];    // 트리

        for (int i = 0; i < h; i++) // 높이만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        TreeSearch(0, size - 1, 0); // 트리 검색, 중위순회

        for (int i = 0; i < h; i++) {   // 높이만큼
            for (int now : A[i])    // 인접리스트 순회
                System.out.print(now + " ");    // 정점 출력
            System.out.println();   // 개행문자 출력
        }
    }
}
