import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 기본 변수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /** (2) 문제 해결 **/
        Queue<Integer> queue = new LinkedList<>(); // 사용할 queue

        // (2-1) 작은 값부터 queue에 집어 넣는다.
        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            // (2-2) 가장 작은 값(First In)을 꺼낸다(First Out).
            queue.poll();
            // (2-2) 2번째로 작은 값을 꺼낸다.
            int temp = queue.poll();
            // (2-3) temp를 다시 queue에 집어 넣는다.
            queue.add(temp);
        }

        /** (3) 정답 출력 **/
        System.out.println(queue.poll());
    }
}
