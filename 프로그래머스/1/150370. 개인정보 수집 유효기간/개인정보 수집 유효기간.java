import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        // today를 day 단위로 변경
        String[] todayArr = today.split("\\.");
        Integer year = Integer.parseInt(todayArr[0]);
        Integer month = Integer.parseInt(todayArr[1]);
        Integer day = Integer.parseInt(todayArr[2]);
        Integer untilToday = year*12*28 + month*28 + day;
        
        // terms를 Map으로 변경
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1])*28); // 저장할 때, day 단위로 저장
        }
        
        // privacies 순회
        ArrayList<Integer> result = new ArrayList<>();
        int index = 1;
        for(String privacy : privacies){
            // 1.
            String[] temp = privacy.split(" ");
            String[] date = temp[0].split("\\.");
            year = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            day = Integer.parseInt(date[2]);
            Integer untilPrivacyDay = year*12*28 + month*28 + day;
            
            String mapKey = temp[1];
            Integer mapValue = map.get(mapKey);
            
            // 2.
            if(untilPrivacyDay + mapValue <= untilToday){
                result.add(index);
            }
            index++;
        }

        return result;
    }
}