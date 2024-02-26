import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 명령어 개수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer count = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>(); // Queue의 마지막 index에 접근해야해서 라이브러리 말고 배열로 직접 구현하기 -> 배열로 구현하면 시간 초과 발생 -> LinkedList 사용
        StringBuilder sb = new StringBuilder(); // [!! 시간 초과 해결 !!] 명령어 한 줄마다 출력하는 것이 아닌 StringBuilder에 쌓아두었다가 한번에 출력할 것

        /** (2) 명령어 개수만큼 명렁어 읽기 **/
        for(int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();
            switch(prompt){ /** (3) 명령어 판별 및 수행 **/
                case "pop":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.poll()).append("\n"); // queue 속 첫번째 값 출력 및 삭제
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
                default: // push
                    queue.offer(Integer.parseInt(st.nextToken())); // queue 마지막에 값 추가
            }
        }

        /** (3) 정답 출력 **/
        System.out.println(sb);
    }
}
