public class 숫자카드나누기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {10, 20}, new int[] {5, 17}));
    }

    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int gcdA = arrayA[0];
            int gcdB = arrayB[0];

            for(int i = 1; i < arrayA.length; i++) {
                gcdA = GCD(gcdA, arrayA[i]);
                gcdB = GCD(gcdB, arrayB[i]);
            }

            if(checkArray(arrayB, gcdA))
                if(answer < gcdA)
                    answer = gcdA;

            if(checkArray(arrayA, gcdB))
                if(answer < gcdB)
                    answer = gcdB;

            return answer;
        }

        public boolean checkArray(int[] arr, int n) {
            for(int num : arr)
                if(num % n == 0)
                    return false;

            return true;
        }

        public int GCD(int a, int b) {
            if(b == 0)
                return a;

            return GCD(b, a % b);
        }
    }
}
