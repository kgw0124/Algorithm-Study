import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        /** (1) 명령어 개수 입력 받기 및 출력할 결과를 저장할 배열 선언 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer count = Integer.parseInt(st.nextToken());

        /** (2)  명령어 개수 만큼 반복문 실행 **/
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();

            switch(prompt){ /** (3) switch문을 통해 명령어 해독 및 수행 **/
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.peek());
                    }
                    break;
                default: // push
                    Integer number = Integer.parseInt(st.nextToken());
                    stack.push(number);
                    break;
            }
        }
    }
}