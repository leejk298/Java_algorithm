import java.util.*;

public class 복습2_0701 {
    static Order[] o;   // 순위배열
    static int[] answer;    // 결과배열

    static class Order {    // 순위 클래스
        // 매개변수
        int index, distance, grade; // 인덱스, 거리, 성적
        String name;    // 이름

        // 파라미터 생성자
        public Order(int index, int grade, int distance, String name) {
            this.index = index;
            this.grade = grade;
            this.distance = distance;
            this.name = name;
        }
    }

    public static void init(String[] names, int[][] homes, double[] grades) {   // 초기화

        // 초기화
        o = new Order[names.length];
        answer = new int[names.length];

        for(int i = 0; i < o.length; i++) { // 크기만큼
            int index = i + 1;  // 인덱스
            String name = names[i]; // 이름
            int d = (int)Math.pow(homes[i][0], 2) + (int)Math.pow(homes[i][1], 2);  // 거리
            int g = (int)grades[i]; // 성적

            o[i] = new Order(index, g, d, name);    // 객체 생성
        }
    }

    public static void sortOrder() {    // 순위 정하기

        // 학점 -> 거리 -> 이름(사전순)
        Arrays.sort(o, (o1, o2) -> {    // 정렬
            if(o1.grade == o2.grade) {  // 학점이 같으면
                if(o1.distance == o2.distance) {    // 거리가 같으면
                    return o1.name.compareTo(o2.name);  // 이름: 사전순
                }

                // 거리가 다르면 그대로 거리 내림차순
                return o2.distance - o1.distance;
            }

            // 학점이 다르면 그대로 학점 내림차순
            return o2.grade - o1.grade;
        }); // sort()

        int rank = 1;   // 순위 1부터
        for(int i = 0; i < o.length; i++)   // 크기만큼
            answer[o[i].index - 1] = rank++;    // 해당하는 인덱스에 순위 저장
    }

    public static int[] solution(String[] names, int[][] homes, double[] grades) {

        init(names, homes, grades); // 초기화

        sortOrder();    // 순위 정하기

        return answer;  // 결과배열 리턴
    }

    public static void main(String[] args) {

        String[] names = new String[] {"lee", "kim", "park"};
        int[][] homes = new int[][] {{1, 4}, {2, 3}, {3, 2}};
        double[] grades = new double[] {4.2, 3.9, 3.2};

        System.out.println(Arrays.toString(solution(names, homes, grades)));
    }
}
