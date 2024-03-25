import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] checker;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터(node)의 개수 = 이차배열의 크기
        int M = Integer.parseInt(br.readLine());

        // 이차배열(graph)과 방문 여부를 저장할 배열(checker) 생성
        graph = new int[N+1][N+1]; // 이차배열 크기를 컴퓨터의 개수+1로 생성 : 0으로 초기화
        checker = new boolean[N+1]; // node 방문 여부 저장 : false로 초기화

        StringTokenizer st = null;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1; // 방향이 없는 간선이므로 (x,y), (y,x) 모두 표시
        }

        // DFS
        DFS(1);

        // 정답 출력
        System.out.println(result);
    }

    public static void DFS(int node){
        checker[node] = true; // (1) node에 방문했다고 정보 저장

        for(int i=1; i<checker.length; i++){
            if(graph[node][i] == 1 && !checker[i]){ // (2) node가 존재하며 + 방문하지 않은 node일 경우
                result++;
                DFS(i);
            }
        }
    }
}