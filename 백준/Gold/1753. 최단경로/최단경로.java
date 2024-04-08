import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Node implements Comparable<Node>{
        int next;
        int weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return weight - n.weight;
        }
    }

    static ArrayList<Node>[] graph = null;
    static int[] distance = null;
    static boolean[] checker = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수 
        int K = Integer.parseInt(br.readLine()); // 출발 노드

        // graph 채우기
        graph = new ArrayList[V+1];
        for(int i=1; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, w));
        }

        distance = new int[V+1];
        checker = new boolean[V+1];
        
        // 다익스트라 시작
        dij(K);

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V+1; i++){
            if(distance[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void dij(int start){
        // [1] distance 배열을 짱 큰 수로 채운다.
        Arrays.fill(distance, Integer.MAX_VALUE);

        // [2] 기본 세팅
        PriorityQueue<Node> queue = new PriorityQueue<>(); // 우선순위 큐 생성
        queue.add(new Node(start, 0)); // 큐에 시작 노드 넣기
        distance[start] = 0; // 시작 노드 거리 0으로 세팅

        // [3] 최단 거리 탐색 시작
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            checker[temp.next] = true; // 방문 처리

            if(temp.weight > distance[temp.next]) continue;

            for(Node n : graph[temp.next]){ // n : temp에서 이동할 다음 노드
                if(!checker[n.next] && distance[temp.next] + n.weight < distance[n.next]){
                    distance[n.next] = distance[temp.next] + n.weight;
                    queue.add(new Node(n.next, distance[n.next]));
                }
            }
        }
    }
}