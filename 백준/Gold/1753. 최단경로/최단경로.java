import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int V;
    static ArrayList<Node>[] graph;
    static boolean[] checker;
    static int[] distance;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // graph
        graph = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, w));
        }
        
        // 디엑스트라
        dij(K);

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<V+1; i++){
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void dij(int start){
        // distance
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // checker
        checker = new boolean[V+1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.offer(new Node(start,0));

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            checker[temp.next] = true;
            for(Node node : graph[temp.next]){
                if (!checker[node.next]){
                    if (distance[temp.next] + node.weight < distance[node.next]){
                        distance[node.next] = distance[temp.next] + node.weight;
                        queue.offer(new Node(node.next, distance[node.next]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    public int next;
    public int weight;

    @Override
    public int compareTo(Node n){
        return this.weight - n.weight;
    }

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}