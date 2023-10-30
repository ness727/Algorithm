import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        StringBuilder result = new StringBuilder();
        HashMap<String, String> idMap = new HashMap<>();
        String[] answer;
        
        for (int i = record.length - 1; i >= 0; i--) {
            String[] split = record[i].split(" ");
            
            if (split[0].equals("Leave")) result.append(record[i]).append("/");
            else {
                if (!idMap.containsKey(split[1])) idMap.put(split[1], split[2]);
                if (split[0].equals("Enter")) 
                    result.append(idMap.get(split[1])).append("님이 들어왔습니다.").append("/");
            }
        }
        
        answer = result.toString().split("/");
        for (int i = 0; i < answer.length / 2 + (answer.length % 2 == 0 ? 0 : 1); i++) {
            String temp = answer[answer.length - (1 + i)];
            
            if (temp.contains("Leave ")) {
                temp = new StringBuilder()
                    .append(idMap.get(temp.split(" ")[1])).append("님이 나갔습니다.").toString();
            }
            if (answer[i].contains("Leave ")) {
                answer[i] = new StringBuilder()
                    .append(idMap.get(answer[i].split(" ")[1])).append("님이 나갔습니다.").toString();
            }
            
            answer[answer.length - (1 + i)] = answer[i];
            answer[i] = temp;
        }
        
        return answer;
    }
}