import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // (1) 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[301]; // [런타임 에러 해결] 0번째 index : 시작
        for(int i=1; i<n+1; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        // (2) 계단 오르기
        int[] score = new int[301]; // [런타임 에러 해결] 점수 저장
        score[1] = stair[1];
        score[2] = stair[1] + stair[2]; // !! 조심 !!
        for(int i=3; i<score.length; i++){
            score[i] = Math.max(score[i-2], score[i-3]+stair[i-1]) + stair[i];
        }
        
        // (3) 답 출력
        System.out.println(score[n]);
    }
}