import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static char[] words; // 임의의 DNA 문자열
    private static int[] minArr = new int[4]; // 각 문자별 최소 개수 저장 배열
    private static int[] countArr = new int[4]; // 각 문자별 개수 저장 배열

    public static void main(String[] args) throws IOException {
        /** 기본 조건 변수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 임의의 DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        words = br.readLine().toCharArray();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        minArr[0] = Integer.parseInt(st2.nextToken()); // A
        minArr[1] = Integer.parseInt(st2.nextToken()); // C
        minArr[2] = Integer.parseInt(st2.nextToken()); // G
        minArr[3] = Integer.parseInt(st2.nextToken()); // T

        /** 탐색 시작 **/
        int answer = 0;

        // 첫 번째 부분 문자열 생성
        for(int i=0; i<P; i++){
            add(i);
        }

        if(isAnswer()){
            answer++;
        }

        for(int i=1; i<=S-P; i++){
            remove(i - 1); // 부분 문자열 중 첫번째 문자 삭제
            add(i + P - 1); // 부분 문자열 마지막에 새로운 문자 추가
            
            if(isAnswer()){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void remove(int i){
        if(words[i] == 'A'){
            countArr[0]--;
        }else if(words[i] == 'C'){
            countArr[1]--;
        }else if(words[i] == 'G'){
            countArr[2]--;
        }else if(words[i] == 'T'){
            countArr[3]--;
        }
    }

    public static void add(int i){
        if(words[i] == 'A'){
            countArr[0]++;
        }else if(words[i] == 'C'){
            countArr[1]++;
        }else if(words[i] == 'G'){
            countArr[2]++;
        }else if(words[i] == 'T'){
            countArr[3]++;
        }
    }

    public static boolean isAnswer(){
        boolean result = true;
        for(int i=0; i<4; i++){
            if(countArr[i] < minArr[i]){
                result = false;
                break;
            }
        }
        return result;
    }
}