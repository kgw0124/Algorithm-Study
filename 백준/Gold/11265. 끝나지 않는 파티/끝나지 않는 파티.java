import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // (1) graph & graph 생성
        graph = new int[N+1][N+1]; // 파티장의 번호가 1부터 시작
        for(int i=1; i<N+1; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;
            }
        }

        // (2) 각 노드마다 나머지 노드로 가는 최단 경로 찾기 : i -> k -> j
        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }

        /*
        for(int i=0; i<N+1; i++){
            System.out.println(Arrays.toString(graph[i]));
        }
         */

        // (3) 사용자 처리
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(graph[A][B] > C){
                sb.append("Stay here").append("\n");
            }else{
                sb.append("Enjoy other party").append("\n");
            }
        }
        System.out.print(sb);
    }
}