import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer N; // 숫자 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());

        Integer result = 0; // 숫자들의 총합
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String numbs = st2.nextToken();
        for(int i=0; i<N; i++){
            result += Integer.parseInt(String.valueOf(numbs.charAt(i)));
        }

        System.out.println(result);
    }
}