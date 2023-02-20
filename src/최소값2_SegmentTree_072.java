import java.io.*;
import java.util.*;

public class 최소값2_SegmentTree_072 {
    static long tree[]; // 트리

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 질의 개수
        int treeHeight = 0, t = N; // 트리높이(k), N

        while (t != 0) { // 2^k >= N => k 구하기
            t /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1); // 배열크기: 2^k * 2 = 2^(k+1)
        int leafNodeStartIndex = treeSize / 2; // 원본데이터(리프노드)시작 인덱스

        tree = new long[treeSize]; // 트리 초기화
        for (int i = 0; i < treeSize; i++)
            tree[i] = Integer.MAX_VALUE; // 전부 Max로 => 최소값 찾기위해

        for (int i = leafNodeStartIndex; i < leafNodeStartIndex + N; i++) // 원본데이터
            tree[i] = Long.parseLong(bf.readLine()); // 리프노드 저장

        setTree(treeSize - 1); // 세그먼트 트리 만들기

        for (int i = 0; i < M; i++) { // 질의 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝

            S = S + leafNodeStartIndex - 1; // 리프노드 인덱스로 갱신
            E = E + leafNodeStartIndex - 1;

            System.out.println(getMin(S, E)); // 최소값 찾기
        }

        bf.close(); // 입력 버퍼 닫기
    }

    private static long getMin(int S, int E) { // 최소값
        long min = Long.MAX_VALUE; // 최대값으로 초기화 => 최소값 찾기위해

        while (S <= E) { // 역전이 아니면 반복
            if (S % 2 == 1) { // 오른쪽 노드이면 독립노드 => 부모노드 영향 X
                min = Math.min(min, tree[S]); // 최소값 저장
                S++; // 왼쪽이면 오른쪽으로, 오른쪽이면 독립노드 다음 노드로 건너띔
            }

            if (E % 2 == 0) { // 왼쪽 노드이면 독립노드 => 부모노드 영향 X
                min = Math.min(min, tree[E]); // 최소값 저장
                E--; // 오른쪽이면 왼쪽으로, 왼쪽이면 독립노드 다음 노드로 건너띔
            }

            S /= 2; // 부모노드로 이동
            E /= 2; // 부모노드로 이동
        }

        return min; // 최소값 리턴
    }

    private static void setTree(int i) { // 세그먼트 트리 만들기
        while (i != 1) { // 루트 노드가 아니면
            if (tree[i / 2] > tree[i]) // 최소값 저장
                tree[i / 2] = tree[i];
            i--; // 인덱스 이동
        }

    }
}
