import java.util.*;

/*
6
10 20 10 30 20 50
 */

public class 가장긴증가하는부분수열2_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열
    static List<Integer> list;  // 결과 리스트

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = sc.nextInt();  // 입력배열 저장
    }

    public static void printMaxLength() {   // 최대 길이 출력

        list.add(0);    // 0을 삽입, 구현을 위해

        for(int i : arr) {  // 입력배열 순회
            if(i > list.get(list.size() - 1))   // 크면
                list.add(i);    // 삽입
            else {  // 작으면
                int S = 0, E = list.size() - 1; // 위치 인덱스

                while(S < E) {  // 역전이 아니면 반복
                    int mid = (S + E) / 2;  // 중앙값

                    if(list.get(mid) < i)   // 크면
                        S = mid + 1;    // 시작 인덱스 갱신
                    else    // 작으면
                        E = mid;    // 끝 인덱스 갱신
                }

                list.set(E, i); // 역전이 일어나서 반복문이 종료되면 끝 위치에 덮어씌움
            }
        }

        System.out.println(list.size() - 1);    // 길이, 0은 빼야하므로 -1
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxLength();   // 최대 길이 출력
    }
}
