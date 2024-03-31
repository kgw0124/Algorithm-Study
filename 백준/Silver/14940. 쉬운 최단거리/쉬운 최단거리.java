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
    static int[][] distance;
    static int[][] checker;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][M+1];
        distance = new int[N+1][M+1];
        checker = new int[N+1][M+1];

        // graph 초기화
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(graph[i][j] == 2){ // 목표 지점을 찾았다!
                    queue.add(new int[]{i, j});
                    checker[i][j] = -1;
                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        getNextNode(temp[0],temp[1]);
                    }
                }
            }
        }

        // 방문하지 못한 node는 distance를 -1로 설정해줘야 한다.
        // [반례] graph에서 node 값이 0 또는 2라면 distance에서 node 값을 0으로 유지해야 한다.
        // 즉, graph에서 node 값이 1일 때만 방문하지 못할 경우 -1로 설정해야 한다.
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(checker[i][j] != -1 && graph[i][j] == 1){
                    distance[i][j] = -1;
                }
            }
        }

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void getNextNode(int x, int y){
        int right = y+1; // 1 ~ M
        int left = y-1;
        int up = x-1; // 1 ~ N
        int down = x+1;

        // graph[][]가 1일때만 queue에 넣는 이유
        // 0을 넣으면 -> 0인 node의 자식 노드로 이동할 때 -> 0을 queue에 넣어서 더해진 1이 누적되어 진행되기 때문

        if(right<=M && checker[x][right]!=-1){
            checker[x][right]=-1;
            if(graph[x][right]==1){
                queue.add(new int[]{x, right});
                distance[x][right] = distance[x][y] + 1;
            }
        }
        if(left>=1 && checker[x][left]!=-1){
            checker[x][left]=-1;
            if(graph[x][left]==1){
                queue.add(new int[]{x, left});
                distance[x][left] = distance[x][y] + 1;
            }
        }
        if(up>=1 && checker[up][y]!=-1){
            checker[up][y]=-1;
            if(graph[up][y]==1){
                queue.add(new int[]{up, y});
                distance[up][y] = distance[x][y] + 1;
            }
        }
        if(down<=N && checker[down][y]!=-1){
            checker[down][y]=-1;
            if(graph[down][y]==1){
                queue.add(new int[]{down, y});
                distance[down][y] = distance[x][y] + 1;
            }
        }
    }
}