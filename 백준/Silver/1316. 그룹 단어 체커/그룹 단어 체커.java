import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /** 변수 **/
        Integer count;
        String[] words;
        Integer correct = 0;

        /** 사용자에게 입력 받기 **/
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        words = new String[count];
        for(int i=0; i<count; i++){
            words[i] = sc.next();
        }

        /** 그룹 단어 개수 세기 **/
        for(int i=0; i<count; i++){
            // 단어를 구성하는 문자 분석 - 문자 : [인덱스] 형태
            HashMap<String, ArrayList<Integer>> letters = new HashMap<>();
            for(int j=0; j<words[i].length(); j++){
                String letter = String.valueOf(words[i].charAt(j));
                if(letters.containsKey(letter)){
                    letters.get(letter).add(j);
                }else{
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(j);
                    letters.put(letter, index);
                }
            }
            // 그룹 단어인지 파악
            Boolean isCorrect = true;
            for(Map.Entry<String, ArrayList<Integer>> entry : letters.entrySet()){
                if(entry.getValue().size() != 1){
                    for(int x=0; x<entry.getValue().size()-1; x++){ // 마지막 index는 처리하지 않음
                        Integer nextIndex = entry.getValue().get(x+1);
                        if(nextIndex != entry.getValue().get(x)+1){
                            isCorrect = false;
                        }
                    }
                }
            }
            // 그룹 단어 개수 세기
            if(isCorrect){
                correct++;
            }
        }
        System.out.println(correct);
    }
}