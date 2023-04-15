import java.util.*;

/**
 4
 2 40
 9 12
 7 15
 5 7

 5
 1 15
 2 14
 3 13
 4 12
 5 11

 6
 12 8
 14 14
 10 9
 2 13
 5 11
 8 9
 */

public class 코테복기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new int[] {x, y});
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        Stack<Integer> stack = new Stack<>();

        stack.push(list.get(0)[1]);
        int sum = 0;
        for(int i = 1; i < N; i++) {
            int score = list.get(i)[1];

            while(!stack.isEmpty() && stack.peek() > score) {
                sum += score;
                stack.pop();
            }

            stack.push(score);
        }

        while(!stack.isEmpty())
            sum += stack.pop();

        System.out.print(sum);
    }
}
