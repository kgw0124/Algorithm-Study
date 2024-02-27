import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 스택 생성 **/
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prompt = br.readLine();
        /** (2) prompt 분석 : (은 stack에 push하고, )은 stack에서 pop하면서 레이저, 막대기 판단 **/
        int result = 0;
        for(int i=0; i<prompt.length(); i++){
            if(prompt.charAt(i) == '('){
                stack.push('(');
            }else{ // prompt.chartAt(i)가 ')'인 경우
                stack.pop(); // stack 속 )와 대응되는 ( 삭제

                if(prompt.charAt(i-1) == '('){ // ()인 경우 = 레이저인 경우
                    result += stack.size();
                }else{ // ))인 경우 = 레이저가 아닌 경우 = 막대기인 경우
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}