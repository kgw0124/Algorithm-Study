import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 피연산자 개수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        double[] numbs = new double[count];

        /** (2) 후위표기식 읽기 **/
        String prompt = br.readLine();

        /** (3) 피연산자의 내용을 numbs 배열 채우기 **/
        for(int i=0; i<count; i++){
            numbs[i] = Double.parseDouble(br.readLine());
        }

        /** (4) 후위표기실 해독 **/
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<prompt.length();i++){
            double x;
            double y;
            switch (prompt.charAt(i)){
                case '+':
                    x = stack.pop();
                    y = stack.pop(); // 더 앞에 값
                    stack.push(y+x);
                    break;
                case '-':
                    x = stack.pop();
                    y = stack.pop(); // 더 앞에 값
                    stack.push(y-x);
                    break;
                case '*':
                    x = stack.pop();
                    y = stack.pop(); // 더 앞에 값
                    stack.push(y*x);
                    break;
                case '/':
                    x = stack.pop();
                    y = stack.pop(); // 더 앞에 값
                    stack.push(y/x);
                    break;
                default:
                    int numbsIndex = prompt.charAt(i) - 'A';
                    double numb = numbs[numbsIndex];
                    stack.push(numb);
                    break;
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}