import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> result = new ArrayList<>();
        Pattern strPattern = Pattern.compile("[a-zA-Z .-]+");
        Pattern numPattern = Pattern.compile("\\d+");
        Matcher matcher;
        
        for (int i = 0; i < files.length; i++) {
            String[] fileSplit = new String[2];
            
            matcher = strPattern.matcher(files[i]);
            if (matcher.find()) fileSplit[0] = matcher.group().toLowerCase();
            
            matcher = numPattern.matcher(files[i]);
            if (matcher.find()) fileSplit[1] = matcher.group();
            
            result.add(new File(fileSplit[0], Integer.parseInt(fileSplit[1]), i));
        }
        Collections.sort(result, File::compareTo);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = files[result.get(i).getIndex()];
        }
        return answer;
    }
    
    class File implements Comparable<File> {
        private String head;
        private int number;
        private int index;
        
        public File(String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }
        
        public String getHead() {
            return this.head;
        }
        
        public int getNumber() {
            return this.number;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        @Override
        public int compareTo(File f) {
            int result = this.head.compareTo(f.getHead());
            if (result == 0) {  // head가 같으면
                if (this.number == f.getNumber()) {  // number가 같으면
                    return this.index < f.getIndex() ? -1 : 1;
                }
                else {
                    return this.number < f.getNumber() ? -1 : 1;
                }
            }
            else {
                return result;
            }
        }
    }
}