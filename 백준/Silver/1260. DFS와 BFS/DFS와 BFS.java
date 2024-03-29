import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // DFS
    static ArrayList<Integer>[] graph1 = null; // 메모리 초과 문제를 방지하기 위해 int[][] 대신 사용
    static boolean[] checker1 = null;
    static StringBuilder sb1 = new StringBuilder();

    // BFS
    static ArrayList<Integer>[] graph2 = null; // 메모리 초과 문제를 방지하기 위해 int[][] 대신 사용
    static boolean[] checker2 = null;
    static StringBuilder sb2 = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // node의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 node의 번호

        // 이차배열 + 방문 여부 저장 배열 생성
        graph1 = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph1[i] = new ArrayList<>();
        }
        checker1 = new boolean[N+1];
        graph2 = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph2[i] = new ArrayList<>();
        }
        checker2 = new boolean[N+1];

        // 이차배열에 node 표시
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 간선
            graph1[x].add(y);
            graph1[y].add(x);
            graph2[x].add(y);
            graph2[y].add(x);
        }

        // 간선 관계를 가진 node가 여러 개인 경우, 작은 node부터 방문하기 때문
        for(int i=1; i<N+1; i++){
            Collections.sort(graph1[i]);
            Collections.sort(graph2[i]);
        }
        
        DFS(V);
        System.out.println(sb1);
        
        BFS(V);
        System.out.println(sb2);
    }

    public static void DFS(int startNode){
        checker1[startNode] = true;
        sb1.append(startNode).append(" ");

        for(int endNode : graph1[startNode]){
            if(!checker1[endNode]) {
                DFS(endNode);
            }
        }
    }

    public static void BFS(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        checker2[startNode] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            sb2.append(temp).append(" ");

            for(int endNode : graph2[temp]){
                if(!checker2[endNode]){
                    queue.add(endNode);
                    checker2[endNode] = true;
                }
            }
        }
    }
}