import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // DFS
    static int[][] graph1 = null;
    static boolean[] checker1 = null;
    static StringBuilder sb1 = new StringBuilder();

    // BFS
    static int[][] graph2 = null;
    static boolean[] checker2 = null;
    static StringBuilder sb2 = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // node의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 node의 번호

        // 이차배열 + 방문 여부 저장 배열 생성
        graph1 = new int[N+1][N+1];
        checker1 = new boolean[N+1];
        graph2 = new int[N+1][N+1];
        checker2 = new boolean[N+1];

        // 이차배열에 node 표시
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph1[x][y] = graph1[y][x] = 1;
            graph2[x][y] = graph2[y][x] = 1;
        }

        DFS(V);
        System.out.println(sb1);

        BFS(V);
        System.out.println(sb2);
    }

    public static void DFS(int startNode){
        checker1[startNode] = true;
        sb1.append(startNode).append(" ");

        for(int i=1; i<checker1.length; i++){
            if(graph1[startNode][i] == 1 && !checker1[i]){
                DFS(i);
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
            
            for (int i = 1; i < checker2.length; i++) {
                if (graph2[temp][i] == 1 && !checker2[i]) {
                    queue.add(i);
                    checker2[i] = true;
                }
            }
        }
    }
}