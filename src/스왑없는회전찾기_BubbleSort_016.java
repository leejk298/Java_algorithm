import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스왑없는회전찾기_BubbleSort_016 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int N = Integer.parseInt(bf.readLine()); // 크기, 한 줄 스트링 정수로 파싱

        mData A[] = new mData[N]; // mData형 배열

        for (int i = 0; i < N; i++) // 배열 저장
            A[i] = new mData(Integer.parseInt(bf.readLine()), i); // 값과 인덱스

        Arrays.sort(A); // 정렬

        int Max = 0;

        for (int i = 0; i < N; i++) { // 정렬 후 인덱스가 제일 차이나는 값 찾기
            if (Max < A[i].index - i) // 정렬 후 idx - 정렬 전 idx
                Max = A[i].index - i;
        }

        System.out.println(Max + 1); // 정렬을 수행한 다음 + 1번째 인덱스에서부터는 정렬이 전부 된상태이므로
    }
}

class mData implements Comparable<mData> { // 1. Comparable 클래스 구현 -> 2. compareTo 메소드 오버라이딩(재정의)
    // 클래스 = 멤버변수 + 멤버함수
    int value; // 멤버변수
    int index;

    public mData(int value, int index) { // 멤버함수: 생성자
        super(); // Comparable 클래스 호출
        this.value = value;
        this.index = index;
    }

    // compareTo 메소드 오버라이딩(재정의)
    @Override
    public int compareTo(mData o) { // 값 비교하여 정렬
        return this.value - o.value; // 부호로 값 비교하여 리턴(양수 - 오름차순, 음수, 0 - 내림차순)
    }
}