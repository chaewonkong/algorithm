package KakaoWinterInternship2019;

import java.util.Stack;

public class CraneDollPick {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int k : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][k - 1] > 0) {
                    int target = board[i][k - 1];
                    System.out.println("target: " + target + " stack: " + stack + " board: " + board[i][k-1]);
                    board[i][k - 1] = 0;
                      if (stack.size() > 0) {
                          if (target == stack.peek()) {
                              stack.pop();
                              count += 2;
                              break;
                          }
                      }
                    stack.push(target);
                      break;
                }
            }
        }
        return count;
    }
}
