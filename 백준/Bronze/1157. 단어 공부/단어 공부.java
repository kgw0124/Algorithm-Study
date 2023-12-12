import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 기본 변수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();

        /** (2) 문제 해결 **/
        word = word.toUpperCase(); // (2-1) word를 이루는 모든 알파벳을 대문자로 변경

        boolean hasAnswer = true;
        char maxChar = 0;
        int maxCount = 0;

        while(word.length() > 0){
            char tempChar = word.charAt(0); // ** 개수를 세고자 하는 알파벳 ** toUpperCase() 결과는 일시적이기 때문에 다시 할당해줘야 함

            int beforeLength = word.length();
            word = word.replaceAll(String.valueOf(tempChar), ""); // ** replaceAll() 결과는 일시적이기 때문에 다시 할당해줘야 함
            int afterLength = word.length();
            int tempCount = beforeLength - afterLength;

            // (2-2) 비교를 통한 탐색
            if(tempCount > maxCount){
                hasAnswer = true; /** [반례] abcc 해결 **/
                maxChar = tempChar;
                maxCount = tempCount;
            }else if(tempCount == maxCount){
                hasAnswer = false; /** [반례] abcc 해결 **/
            }
        }

        /** (3) 정답 출력 **/
        if(hasAnswer){
            System.out.println(maxChar);
        }else{
            System.out.println("?");
        }
    }
}