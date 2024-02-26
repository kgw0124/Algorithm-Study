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

        /** (2)  명령어 개수 만큼 반복문 실행 **/
        for(int i=0; i<count; i++){
            Stack<String> stack = new Stack<>();
            boolean result = true;

            /*
            st = new StringTokenizer(br.readLine(), "");
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                System.out.println("word : " + word); // word가 (, ) 한 개씩 쪼개지지 않고, 한 줄 통으로 들어와서 오류 발생
                if(word.contains("(")){
                    stack.push("(");
                }else{
                    if(stack.isEmpty()){
                        result = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
             */

            String[] words = br.readLine().split(""); /** (3) 명령어 한 줄을 (,) 한 개씩 쪼개기 **/
            for (String word : words) {
                if (word.equals("(")) { /** (3-1) (이면 stack에 넣기 **/
                    stack.push("(");
                } else { /** (3-2) )이면 stack에서 빼기 **/
                    if (stack.isEmpty()) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            /** (4) 최종 판별 및 결과 출력 **/
            if(!result){
                System.out.println("NO");
                continue;
            }

            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}