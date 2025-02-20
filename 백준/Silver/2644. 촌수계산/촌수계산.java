import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String dfs_path = "";

    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        // 2. graph와 checker 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] checker = new boolean[n+1];
        
        // 3. 촌수 계산
        System.out.println(BFS(graph, checker, start, end));
    }

    public static int BFS(ArrayList<ArrayList<Integer>> graph, boolean[] checker, int start, int end){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // [노드 번호, 탐색하는 너비의 순서]
        checker[start] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int init = temp[0]; // 부모 노드 번호
            int cnt = temp[1]; // 부모 노드가 속한 너비의 순서

            if(init == end){
                return cnt;
            }

            for(int next: graph.get(init)){
                if (!checker[next]){
                    queue.add(new int[]{next, cnt+1}); // [자식 노드 번호, 자식 노드가 속한 너비의 순서(부모+1)]
                    checker[next] = true;
                }
            }
        }

        return -1;
    }
}