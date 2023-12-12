import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 기본 변수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /** (2) 문제 해결 **/
        int answer = 0;
        while(st.hasMoreTokens()){
            if(st.nextToken() != " "){
                answer++;
            }
        }

        /** (3) 정답 출력 **/
        System.out.println(answer);
    }
}