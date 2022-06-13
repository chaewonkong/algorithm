package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConnectNetwork {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Edge[] network = new Edge[M];
        int[] parent = new int[N + 1];

        // parent 배열을 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 정점과 간선 입력을 network에 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            network[i] = new Edge(start, end, weight);
        }

        br.close();

        Arrays.sort(network);
        for (int i = 0; i < M; i++) {
            Edge edge = network[i];

            if (!hasSameParent(parent, edge.start, edge.end)) { // 사이클이 발생하지 않는다면
                // 간선을 연결하고 비용을 가산
                union(parent, edge.start, edge.end);
                ans += edge.weight;
            }
        }

        System.out.println(ans);
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = getParent(parent, parent[x]);
        return parent[x];
    }

    // 두 부모를 합치는 함수. 더 작은 부모로 합친다.
    private static void union(int[] parent, int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    // 같은 부모를 가지는지 확인
    private static boolean hasSameParent(int[] parent, int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);
        return x == y;
    }
}
