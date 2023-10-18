import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 개수 입력 받기
        Integer N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 테스트 케이스 입력 받기
        Integer[] results = new Integer[N];
        for(int i=0; i<N; i++){
            Integer testCase = Integer.parseInt(br.readLine());
            Integer result = 1; // 1로만 구성된 경우 카운트
            //(1) 반드시 3을 사용하는 경우 : (1, 2, 3) / (1, 3) / (2, 3) / (3)
            Integer max1 = 0;
            Integer max2 = 0;
            Integer max3 = testCase/3;
            for(int count3=1; count3<=max3; count3++){ //반드시 3을 사용하니깐 1부터 시작
                max2 = (testCase - (3 * count3))/2;
                for(int count2=0; count2<=max2; count2++){
                    if(max2 == 0) { // (1, 3) / (3)
                        max1 = testCase - (3 * count3);
                        result += count(max1, 0, count3);
                    }else{ // (1, 2, 3) / (2, 3)
                        max1 = testCase - (3 * count3) - (2 * count2);
                        result += count(max1, count2, count3);
                    }
                }
            }

            //(2) 반드시 3을 제외하고 2를 사용하는 경우 : (1, 2) / (2)
            max2 = testCase/2;
            for(int count2=1; count2<=max2; count2++){ //반드시 2를 사용하니깐 1부터 시작
                max1 = testCase - (2 * count2);
                result += count(max1, count2, 0);
            }
            
            //결과 저장
            results[i] = result;
        }

        for(int i=0; i<results.length; i++){
            System.out.println(results[i]);
        }
    }

    public static Integer count(Integer count1, Integer count2, Integer count3){
        Integer factorialAll = factorial(count1 + count2 + count3);
        Integer factorial1 = (factorial(count1) == 0 ) ? 1 : factorial(count1);
        Integer factorial2 = (factorial(count2) == 0 ) ? 1 : factorial(count2);
        Integer factorial3 = (factorial(count3) == 0 ) ? 1 : factorial(count3);
        Integer result = factorialAll / factorial1 / factorial2 / factorial3;
        return result;
    }

    public static Integer factorial(Integer numb){
        Integer result = 1;
        for(int i=1; i<=numb; i++){
            result *= i;
        }
        return result;
    }
}