import java.util.*;

class Solution {
    String[] answer;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        answer = new String[n];
        
        for(int i=0; i<n; i++){
            String arr1_binary = fill(n, Integer.toBinaryString(arr1[i]));
            String arr2_binary = fill(n, Integer.toBinaryString(arr2[i]));
            System.out.println(arr1_binary + " | " + arr2_binary);
            
            answer[i] = "";
            decode(n, i, arr1_binary, arr2_binary);
        }
        
        return answer;
    }
    
    public String fill(Integer length, String input){
        if(input.length()<length){
            String extraZero = "";
            for(int i=0; i<length-input.length(); i++){
                extraZero += "0";
            }
            return extraZero + input;
        }
        return input;
    }
    
    public void decode(Integer length, Integer row, String arr1, String arr2){
        for(int i=0; i<length; i++){
            if(arr1.charAt(i) == '0' && arr2.charAt(i) == '0'){
                answer[row] += " ";
            }else{
                answer[row] += "#";
            }
        }
    }
}