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

        // (1) input을 1. 두 자리 이상의 수 2. - 3. +을 기준으로 쪼갠다.
        Pattern pattern = Pattern.compile("\\d+|[-+]");
        Matcher matcher = pattern.matcher(input);

        // (2) (1)의 결과값을 +인 경우, 계산을 수행한다. +가 아닌 경우, arr 뒤에 삽입한다.
        ArrayList<String> arr = new ArrayList<>();
        while(matcher.find()){
            String temp = matcher.group();
            switch (temp){
                case "+":
                    int x = Integer.parseInt(arr.get(arr.size()-1));
                    int y = 0;
                    if(matcher.find()){
                        y = Integer.parseInt(matcher.group());
                    }
                    arr.set(arr.size()-1, String.valueOf(x+y));
                    break;
                default:
                    arr.add(temp);
                    break;
            }
        }

        // (3) arr의 앞부터 차례대로 뺄셈 연산을 수행한다. 이때 arr의 짝수 인덱스는 수, 홀수 인덱스에는 -가 저장되어 있다.
        int result = Integer.parseInt(arr.get(0));
        for(int i=2; i<arr.size(); i+=2){
            result -= Integer.parseInt(arr.get(i));
        }

        System.out.println(result);
    }
}