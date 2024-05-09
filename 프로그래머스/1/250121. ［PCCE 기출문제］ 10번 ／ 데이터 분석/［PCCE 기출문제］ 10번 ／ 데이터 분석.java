import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. ext
        ArrayList<int[]> afterExt = new ArrayList<>();
        switch(ext){
            case "code":
                afterExt = doExt(data, 0, val_ext);
                break;
            case "date":
                afterExt = doExt(data, 1, val_ext);
                break;
            case "maximum":
                afterExt = doExt(data, 2, val_ext);
                break;
            case "remain":
                afterExt = doExt(data, 3, val_ext);
                break;
        }
        
        // 2. sort
        switch(sort_by){
            case "code":
                afterExt.sort((d1, d2) -> d1[0] - d2[0]);
                break;
            case "date":
                afterExt.sort((d1, d2) -> d1[1] - d2[1]);
                break;
            case "maximum":
                afterExt.sort((d1, d2) -> d1[2] - d2[2]);
                break;
            case "remain":
                afterExt.sort((d1, d2) -> d1[3] - d2[3]);
                break;
        }
        
        int[][] answer = new int[afterExt.size()][4];
        for(int i=0; i<afterExt.size(); i++){
            answer[i][0] = afterExt.get(i)[0];
            answer[i][1] = afterExt.get(i)[1];
            answer[i][2] = afterExt.get(i)[2];
            answer[i][3] = afterExt.get(i)[3];
        }
        return answer;
    }
    
    public ArrayList<int[]> doExt(int[][] data, int indexExt, int val_ext){
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(data[i][indexExt] < val_ext){
                result.add(data[i]);
            }
        }
        return result;
    }
}