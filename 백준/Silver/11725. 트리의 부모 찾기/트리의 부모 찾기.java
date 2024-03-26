import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph = null; // (!!) [**메모리 초과/ 시간 초과 문제 해결**] int[N+1][N+1] 대신 사용
    static int[] parentArr = null; // [**메모리 초과 문제 해결**] 부모 노드 저장과 동시에 방문 여부 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수

        // (!!) graph 초기화
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        // N-1개의 간선을 graph에 저장
        StringTokenizer st = null;
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 간선
            graph[x].add(y);
            graph[y].add(x);
        }

        parentArr = new int[N+1]; // 0으로 초기화 : 방문하지 않았다면 인덱스값이 0일 것
        DFS(1);

        for(int i=2; i<=N; i++){
            System.out.println(parentArr[i]);
        }
    }

    public static void DFS(int startNode){
        for(int endNode : graph[startNode]){
            if(parentArr[endNode] == 0){ // 방문하지 않는 node인지 확인
                parentArr[endNode] = startNode;
                DFS(endNode);
            }
        }
    }
}