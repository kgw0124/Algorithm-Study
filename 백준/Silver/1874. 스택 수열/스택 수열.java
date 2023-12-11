import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 기본 변수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] input = new int[n]; // 만들고자 하는 수열
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
        }

        /** (2) 문제 해결 **/
        ArrayList<String> answer = new ArrayList<>(); // push, pop 과정을 저장할 배열
        Stack<Integer> stack = new Stack<>(); // 사용할 stack

        int x = 1;
        int inputIndex = 0;

        while(true){
            if(stack.isEmpty()){ // (1) 처음(x=1)에는 무조건 push
                stack.push(x);
                answer.add("+");
                x++;
            }else{
                if(x > n){ // (2) x가 n보다 커지면, stack 속 모든 값 꺼내기
                    while(!stack.isEmpty()){
                        int top = stack.peek();
                        if(top != input[inputIndex]){ // ** 꺼낸 마지막 값이 input[inputIndex]와 같지 않으면 input을 만들 수 없음
                            answer = new ArrayList<>();
                            answer.add("NO");
                            break;
                        }else{
                            stack.pop();
                            answer.add("-");
                            inputIndex++;
                        }
                    }
                    break;
                }else{ // (3) x와 input 비교하기
                    if(x <= input[inputIndex]){
                        stack.push(x);
                        answer.add("+");
                        x++;
                    }else{
                        int top = stack.peek();
                        if(top != input[inputIndex]){ // ** 꺼낸 마지막 값이 input[inputIndex]와 같지 않으면 input을 만들 수 없음
                            answer = new ArrayList<>();
                            answer.add("NO");
                            break;
                        }else{
                            stack.pop();
                            answer.add("-");
                            inputIndex++;
                        }
                    }
                }
            }
        }

        /** (3) 정답 출력 **/
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}