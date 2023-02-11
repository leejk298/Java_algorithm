import java.util.Scanner;

public class 내림차순정렬_SelectionSort_017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        String str = sc.next(); // 문자열로 받아서
        int A[] = new int[str.length()]; // 문자열길이에 해당하는 크기의 배열 선언

        for (int i = 0; i < str.length(); i++) // 크기 만큼
            A[i] = Integer.parseInt(str.substring(i, i + 1)); // 문자열을 한 글자씩 쪼개서 문자로 만든 후 정수로 파싱하여 저장

        for (int i = 0; i < str.length(); i++) { // 크기 만큼
            int max = i; // 정렬해야하는 구간의 맨 앞이 가장 크다고 초기화

            for (int j = i + 1; j < str.length(); j++) { // 그 이후 만큼
                if (A[j] > A[max]) // 크기 비교후
                    max = j; // 최댓값에 해당하는 인덱스 저장
            }

            if (A[i] < A[max]) // 맨 앞과 최댓값과 비교하여
            {
                int tmp = A[i]; // 큰 값을 앞으로 -> 내림차순
                A[i] = A[max];
                A[max] = tmp;
            }
        }

        for (int i = 0; i < str.length(); i++)
            System.out.println(A[i]);
    }
}
