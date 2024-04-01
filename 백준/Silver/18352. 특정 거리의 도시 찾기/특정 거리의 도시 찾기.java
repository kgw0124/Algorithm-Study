import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static boolean[] checker = null;
    static int[] distance = null;
    static ArrayList<Integer>[] graph = null;
    static ArrayList<Integer> city = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시(=노드) 개수
        int M = Integer.parseInt(st.nextToken()); // 도로(=간선) 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시(=노드)

        checker = new boolean[N+1];
        distance = new int[N+1];

        // graph 초기화
        graph = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        // graph에 간선 정보 채우기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y); // 단방향 간선 : x->y
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X); // 출발
        checker[X] = true;
        while(!queue.isEmpty()){
            int startNode = queue.poll();
            // count++; <-- [틀린 이유]
            for(int nextNode : graph[startNode]){
                if(!checker[nextNode]){
                    queue.add(nextNode);
                    checker[nextNode] = true;
                    distance[nextNode] = distance[startNode] + 1;
                    if(distance[nextNode] == K){
                        city.add(nextNode);
                    }
                }
            }
        }

        // 정답 출력
        if(city.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(city);
            StringBuilder sb = new StringBuilder();
            for(int c: city){
                sb.append(c).append("\n");
            }
            System.out.print(sb);
        }
    }
}