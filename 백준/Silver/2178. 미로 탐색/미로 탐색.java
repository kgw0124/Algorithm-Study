import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[][] graph = null;
    static int[][] distance = null;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean exit = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph 초기화
        graph = new int[N+1][M+1];
        for(int i=0; i<N; i++){ // i:line, j:row
            String line = br.readLine();
            for(int j=0; j<M; j++){
                graph[i+1][j+1] = line.charAt(j) - '0'; // ** char -> int
            }
        }

        // distance 초기화
        distance = new int[N+1][M+1];

        // 미로 찾기 시작
        queue.add(new int[]{1, 1});
        graph[1][1] = -1; // 방문 처리
        while(!exit){
            int[] temp = queue.poll();
            getNextNode(temp[0], temp[1]);
        }
        System.out.println(distance[N][M] + 1); // (1,1) 포함
    }

    public static void getNextNode(int i, int j){ // BFS할 대상 노드 탐색
        int right = j+1;
        int left = j-1;
        int up = i-1;
        int down = i+1;

        // graph 범위를 벗어나지 않으며 방문 이력이 없을 것
        if(right <= M && graph[i][right] == 1){ // 동 : 1~M
            queue.add(new int[]{i, right});
            graph[i][right] = -1;
            distance[i][right] = distance[i][j] + 1;
            if (i == N && right == M) {
                exit = true;
                return;
            }
        }
        if(left >= 1 && graph[i][left] == 1){ // 서 : 1~M
            queue.add(new int[]{i, left});
            graph[i][left] = -1;
            distance[i][left] = distance[i][j] + 1;
            if (i == N && left == M) {
                exit = true;
                return;
            }
        }
        if(down <= N  && graph[down][j] == 1){ // 남 : 1~N
            queue.add(new int[]{down, j});
            graph[down][j]= -1;
            distance[down][j] = distance[i][j] + 1;
            if (down == N && j == M) {
                exit = true;
                return;
            }
        }
        if(up >= 1 && graph[up][j] == 1){ // 북 : 1~N
            queue.add(new int[]{up, j});
            graph[up][j] = -1;
            distance[up][j] = distance[i][j] + 1;
            if (up == N && j == M) {
                exit = true;
                return;
            }
        }
    }
}