import java.util.*;
import java.io.*;

public class 구간곱_SegmentTree_073 {
    static long tree[]; // 트리
    static int mod; // 나머지 연산 수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 업데이트 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간곱 출력 횟수
        int treeHeight = 0, t = N; // 트리높이(k), N

        while (t != 0) { // 2^k >= N, k 구하기
            t /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1); // 배열 크기
        int leafNodeStartIndex = treeSize / 2; // 원본데이터, 리프노드 시작 인덱스

        mod = 1000000007; // 1000000007로 나머지 연산
        tree = new long[treeSize]; // 트리 초기화
        for (int i = 0; i < treeSize; i++) // 전부 1로 => 곱하기 때문에
            tree[i] = 1;

        for (int i = leafNodeStartIndex; i < leafNodeStartIndex + N; i++) // 원본데이터 저장
            tree[i] = Long.parseLong(bf.readLine()); // long 타입으로

        setTree(treeSize - 1); // 세그먼트 트리 만들기, 부모노드 갱신

        for (int i = 0; i < M + K; i++) { // 업데이트, 구간곱 출력
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int a = Integer.parseInt(st.nextToken()); // a
            int S = Integer.parseInt(st.nextToken()); // S
            long E = Long.parseLong(st.nextToken()); // E

            if (a == 1) // a가 1이면 업데이트
                updateValue(S + leafNodeStartIndex - 1, E); // S를 리프노드 인덱스로 갱신

            else if (a == 2) { // a가 2이면 구간곱 출력
                S = S + leafNodeStartIndex - 1; // 리프노드 인덱스로 갱신
                E = E + leafNodeStartIndex - 1;	// => index = index + 2^k - 1

                System.out.println(getMul(S, (int) E)); // 구간곱
            }
        }

        bf.close(); // 입력 버퍼 닫기
    }

    private static long getMul(int S, int E) { // 구간곱
        long mul = 1; // 1로 초기화 => 곱하기 때문에 값변화 X

        while (S <= E) { // 역전이 아니면 반복
            if (S % 2 == 1) { // 오른쪽 노드이면 독립노드 => 부모영향 X
                mul *= tree[S] % mod; // 부분곱 저장
                S++; // 왼쪽이면 오른쪽으로, 오른쪽이면 독립노드 다음 노드로 건너띔
            }

            if (E % 2 == 0) { // 왼쪽 노드이면 독립노드 => 부모영향 X
                mul *= tree[E] % mod; // 부분곱 저장
                E--; // 오른쪽이면 왼쪽으로, 왼쪽이면 독립노드 다음 노드로 건너띔
            }

            S /= 2; // 부모노드로 이동
            E /= 2;
        }

        return mul; // 값 리턴
    }

    private static void setTree(int i) { // 세그먼트 트리 만들기, 부모노드 개인
        while (i != 1) { // 루트노드가 아니면 반복
            tree[i / 2] *= tree[i] % mod; // 부모노드 갱신
            i--; // 인덱스 이동
        }

    }

    private static void updateValue(int index, long value) { // 업데이트
        tree[index] = value; // 값 저장

        while (index > 1) { // 루트노드가 아니면 반복
            index /= 2; // 부모노드로 이동
            tree[index] = tree[index * 2] % mod * tree[index * 2 + 1] % mod; // 부모노드 값 갱신 => 왼 오 자식 곱
        }

    }
}
