import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] graph;
    static int[][] checker;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        checker = new int[N+1][N+1];

        // graph 초기화
        for(int i=1; i<N+1; i++){
            String input = br.readLine();
            for(int j=1; j<N+1; j++){
                graph[i][j] = input.charAt(j-1) - '0';
            }
        }

        // (1) graph 전체를 순환
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                // !! 아파트 단지 찾기 !!
                if(graph[i][j] == 1 && checker[i][j] != -1){ // (2) 값이 1이면서 방문 이력이 없는 node라면
                    queue.add(new int[]{i, j});
                    checker[i][j] = -1;
                    arr.add(1);
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        getNextNode(temp[0], temp[1]); // (3) 해당 node와 연결되면서 값이 1이고, 방문 이력이 없는 node 탐색
                    }
                }
            }
        }

        // 답 출력
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append("\n");
        for(int a : arr){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    public static void getNextNode(int x, int y){
        // 1인 node만 queue에 넣자!

        // 1 ~ N
        int right = y+1;
        int left = y-1;
        int up = x+1;
        int down = x-1;
        int index = arr.size()-1;

        if(right <= N && graph[x][right] == 1 && checker[x][right] != -1){
            queue.add(new int[]{x, right});
            checker[x][right] = -1;
            arr.set(index, arr.get(index)+1);
        }
        if(left >= 1 && graph[x][left] == 1 && checker[x][left] != -1){
            queue.add(new int[]{x, left});
            checker[x][left] = -1;
            arr.set(index, arr.get(index)+1);
        }
        if(up <= N && graph[up][y] == 1 && checker[up][y] != -1){
            queue.add(new int[]{up, y});
            checker[up][y] = -1;
            arr.set(index, arr.get(index)+1);
        }
        if(down >= 1 && graph[down][y] == 1 && checker[down][y] != -1){
            queue.add(new int[]{down, y});
            checker[down][y] = -1;
            arr.set(index, arr.get(index)+1);
        }
    }
}