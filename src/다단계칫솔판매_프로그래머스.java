import java.util.*;

public class 다단계칫솔판매_프로그래머스 {
    static class Solution {
        class Employee {    // 판매원 클래스
            String name;    // 이름
            Employee parent;    // 부모
            int profit; // 이득

            public Employee(String name, Employee parent, int profit) { // 파라미터 생성자
                this.name = name;
                this.parent = parent;
                this.profit = profit;
            }

            public void distribute(int profit) {    // 이득 분배
                int parentProfit = profit / 10; // 부모 이득
                this.profit += profit - parentProfit;   // 자신 이득

                if (this.parent != null && parentProfit >= 1)   // 부모가 있고 부모 이득이 1보다 크면
                    this.parent.distribute(parentProfit);   // 재귀콜, 부모 노드로 이동
            }
        }

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

            Map<String, Employee> hashMap = new HashMap<>();    // 해시맵
            for (String name : enroll)  // 배열 순회
                hashMap.put(name, new Employee(name, null, 0)); // 해시맵 저장

            for (int i = 0; i < enroll.length; i++) {   // 길이만큼
                if (referral[i].equals("-"))    // 부모가 없으면
                    continue;   // 건너띄기
                // 부모가 있으면
                hashMap.get(enroll[i]).parent = hashMap.get(referral[i]);   // 부모 연결
            }

            for (int i = 0; i < seller.length; i++) // 길이만큼
                hashMap.get(seller[i]).distribute(amount[i] * 100); // 해당 이름을 키값으로 하는 판매원 이득 분배

            int[] answer = new int[enroll.length];  // 결과배열
            for (int i = 0; i < answer.length; i++) // 길이만큼
                answer[i] = hashMap.get(enroll[i]).profit;  // 각 판매원의 이득 저장

            return answer;  // 결과배열 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10}));
    }
}
