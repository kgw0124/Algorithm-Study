import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // (1) input을 -를 기준으로 쪼개기 : 각 index에 1. 숫자 2. 숫자+숫자 형식으로 들어간다.
        String[] minusArr = input.split("-");

        // (2) 각 index를 순회하면서 +를 포함한 경우, +를 기준으로 쪼갠 후 더하기 연산을 수행한다.
        for(int i=0; i<minusArr.length; i++){
            if(minusArr[i].contains("+")){
                String[] plusArr = minusArr[i].split("\\+");
                int temp = Integer.parseInt(plusArr[0]);
                for(int j=1; j<plusArr.length; j++){
                    temp += Integer.parseInt(plusArr[j]);
                }
                minusArr[i] = Integer.toString(temp);
            }
        }

        // (3) 뺄셈 수행
        int result = Integer.parseInt(minusArr[0]);
        for(int i=1; i<minusArr.length; i++){
            result -= Integer.parseInt(minusArr[i]);
        }
        System.out.println(result);
    }
}