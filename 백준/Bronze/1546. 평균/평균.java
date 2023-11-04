import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer N; // 점수 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> scores = new ArrayList<>(); // 점수 저장
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            scores.add(Integer.parseInt(st2.nextToken()));
        }

        // (1) 점수 중 최고 점수 추출
        double M = Collections.max(scores);

        // (2) 모든 점수 /M*100 수행 및 총합 구하기
        double total = 0;
        for(int i=0; i<N; i++){
            total += scores.get(i) / M * 100;
        }

        // (3) 평균 구하기
        double avg = total / N;
        System.out.println(avg);
    }
}