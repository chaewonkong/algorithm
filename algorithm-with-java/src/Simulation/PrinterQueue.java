package Simulation;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextByte();
        for (int i = 0; i < tests; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
//                Document doc = new Document(j, sc.nextInt());
                arr[j] = sc.nextInt();
            }
            System.out.println(printOrder(arr, M));
        }
    }

    private static int printOrder(int[] arr, int targetIdx) {
        int[] descArr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Queue<Integer> descQueue = new LinkedList<>();
        Queue<Document> queue = new LinkedList<>();

        for (int val : descArr) {
            descQueue.add(val);
        }

        for (int i = 0; i < arr.length; i++) {
            Document doc = new Document(i, arr[i]);
            queue.add(doc);
        }

        int count = 1;
        while (!descQueue.isEmpty()) {
            int targetPriority = descQueue.peek();
            Document doc = queue.poll();

            if (doc.priority == targetPriority) {
                if (doc.idx == targetIdx) {
                    return count;
                }
                // 인쇄 진행
                descQueue.poll();
                count++;
            } else {
                queue.add(doc);
            }
        }

        return count;
    }
}

class Document{
    int idx;
    int priority;

    public Document(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}
