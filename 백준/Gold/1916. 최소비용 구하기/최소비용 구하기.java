import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Node implements Comparable<Node>{
        int numb;
        int weight;
        
        // 생성자
        Node(int numb, int weight){
            this.numb = numb;
            this.weight = weight;
        }
        
        // for 우선순위 큐 사용
        @Override
        public int compareTo(Node n){
            return weight - n.weight;
        }
    }

    static ArrayList<Node>[] graph = null;
    static int[] distance = null;
    static boolean[] checker = null; // [시간 초과 해결]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        distance = new int[N+1];
        checker = new boolean[N+1];

        // graph 채우기
        graph = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y,w));
        }

        // 출발점, 도착점 입력 받기
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        dij(start);
        System.out.println(distance[end]);
    }

    public static void dij(int start){
        // [1] distance를 짱 큰 수로 채우기
        Arrays.fill(distance, Integer.MAX_VALUE);

        // [2] 다익스트라 시작
        PriorityQueue<Node> queue = new PriorityQueue<>(); // !! 우선순위 큐에 Node를 담아야 한다. !! -> checker을 사용할 수 있는 이유
        queue.add(new Node(start,0));
        distance[start]=0;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            checker[temp.numb] = true;

            // [시간 초과 해결] temp로 직행 > temp로 여러 곳 경유 : 확인하지 않을 것 (최적화)
            if(temp.weight > distance[temp.numb]) continue;

            for(Node n : graph[temp.numb]){
                if(distance[temp.numb] + n.weight < distance[n.numb] && !checker[n.numb]){ // 경유 < 직행
                    distance[n.numb] = distance[temp.numb] + n.weight;
                    queue.add(new Node(n.numb, distance[n.numb])); // !! <-- 여기 조심
                }
            }
        }
    }
}