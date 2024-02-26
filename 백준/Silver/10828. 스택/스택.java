import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 명령어 개수 입력 받기 및 출력할 결과를 저장할 배열 선언 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer count = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        /** (2)  명령어 개수 만큼 반복문 실행 **/
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();

            switch(prompt){ /** (3) switch문을 통해 명령어 해독 및 수행 **/
                case "pop":
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                default: // push
                    Integer number = Integer.parseInt(st.nextToken());
                    stack.push(number);
                    break;
            }
        }

        /** (4) 최종 결과 출력 **/
        System.out.println(sb);
    }
}