import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. graph 생성
        int[][] graph = new int[N+1][M+1];
        for (int i=0; i<N; i++){
            String line = br.readLine();
            for (int j=0; j<M; j++){
                graph[i+1][j+1] = line.charAt(j) - '0';
            }
        }

        // 3. BFS
        Queue<int[]> queue = new LinkedList<>();
        graph[1][1] = -1; // checker 대신 -1로 방문 체크
        queue.add(new int[]{1,1,1});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];

            if(x==N && y ==M){
                System.out.println(cnt);
                break;
            }

            // 상
            if (x+1 <= N && graph[x+1][y] == 1){
                graph[x+1][y] = -1;
                queue.add(new int[]{x+1, y, cnt+1});
            }
            // 하
            if (x-1 >= 1 && graph[x-1][y] == 1){
                graph[x-1][y] = -1;
                queue.add(new int[]{x-1, y, cnt+1});
            }
            // 좌
            if (y-1 >= 1 && graph[x][y-1] == 1){
                graph[x][y-1] = -1;
                queue.add(new int[]{x, y-1, cnt+1});
            }
            // 우
            if (y+1 <= M && graph[x][y+1] == 1){
                graph[x][y+1] = -1;
                queue.add(new int[]{x, y+1, cnt+1});
            }
        }
    }
}