class Solution {
    private static final int HOUR_MOV = 1, MIN_MOV = 12, SEC_MOV = 720;
    // max - 43200
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int timeToSec = (h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1);
        int sec = SEC_MOV * s1;
        int min = MIN_MOV * (m1 * 60 + s1);
        int hour = HOUR_MOV * ((h1 >= 12 ? h1 - 12 : h1) * 3600 + m1 * 60 + s1);
        
        while (--timeToSec >= 0) {
            boolean isHourAlarm = false, isMinAlarm = false;
            if (sec <= hour && hour + HOUR_MOV < sec + SEC_MOV) isHourAlarm = true;
            if (sec <= min && min + MIN_MOV < sec + SEC_MOV) isMinAlarm = true;
            
            if (isHourAlarm || isMinAlarm) {
                if (isHourAlarm && isMinAlarm) {
                    if (hour == min || hour + HOUR_MOV == min + MIN_MOV) answer++;
                    else answer += 2;
                }
                else answer++;
            }
            
            hour = (hour == 43199 ? 0 : hour + HOUR_MOV);
            min = (min == 43188 ? 0 : min + MIN_MOV);
            sec = (sec == 42480 ? 0 : sec + SEC_MOV);
        }
        if (sec == min || sec == hour) answer++;

        return answer;
    }
}