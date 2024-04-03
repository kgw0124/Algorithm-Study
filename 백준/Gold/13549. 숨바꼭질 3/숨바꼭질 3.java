import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] graph = new int[100001]; // 범위가 0 이상 100000 이하이니깐
    static boolean[] checker = new boolean[100001]; // [메모리 초과 원인]
    static Queue<Integer> queue = new LinkedList<>();
    static int N; // 수빈이 자리
    static int M; // 동생 자리
    static boolean findAnswer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // graph 초기화
        for(int i=0; i< graph.length; i++){
            graph[i] = 100000;
        }

        queue.add(N); // 시작
        graph[N] = 0;
        checker[N] = true;
        while(!findAnswer && !queue.isEmpty()){
            int temp = queue.poll(); // 수빈이의 임시 위치
            move(temp); // 수빈이의 임시 위치에서 갈 수 있는 모든 위치 탐색
            //System.out.println(Arrays.toString(graph));
        }

        // 정답 출력
        System.out.println(graph[M]);
    }

    public static void move(int index){
        // 0~100000
        int jump = index*2;
        int left = index-1;
        int right = index+1;

        if(jump<=100000 && !checker[jump]) {
            queue.add(jump);
            graph[jump] = graph[index];
            checker[jump] = true;
            if (jump == M) {
                findAnswer = true;
                return; // move() 종료
            }
        }

        if(left>=0 && !checker[left]) {
            queue.add(left);
            graph[left] = Math.min(graph[left], graph[index] + 1); // 최단 경로 갱신 -> 근데, 가중치가 없는데 대소비교를 해주어야 하나..?? -> 가중치 존재한다! 순간 이동:0, 걷기: 1
            checker[left] = true;
            if (left == M) {
                findAnswer = true;
                return; // move() 종료
            }
        }

        if(right<=100000 && !checker[right]){
            queue.add(right);
            graph[right] = Math.min(graph[right], graph[index] + 1); // 최단 경로 갱신
            checker[right] = true;
            if(right == M){
                findAnswer = true;
                return; // move() 종료
            }
        }
    }
}