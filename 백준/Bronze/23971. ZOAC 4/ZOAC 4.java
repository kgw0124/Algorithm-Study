import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] graph = {};
    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double H = Integer.parseInt(st.nextToken());
        double W = Integer.parseInt(st.nextToken());
        double N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());

        // 2.
        int x = (int) Math.ceil(W / (M + 1));
        int y = (int) Math.ceil(H / (N + 1));
        System.out.println(x*y);

    }
}