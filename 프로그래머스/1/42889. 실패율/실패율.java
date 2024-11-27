import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        // 실패율 저장
        float[] failures = new float[N];
        // 초기 전체 인원
        int playerCnt = stages.length;
        
        // 유저 스테이지 (stages) 오름차순
        Arrays.sort(stages);
        
        // 스테이지별 남아있는 인원 구하기
        // 현재 스테이지 실패율 (머물러있는 인원 / 도달한 인원)
        // 다음 스테이지부터 도달한 인원 -= 이전 스테이지 머물러 있는 인원
        int stage = 1;
        for (int i = 0; i < stages.length && stage <= N;) {
            // 현재 스테이지 머물러 있는 인원 구하기
            int curStagePlayer = 0;
            while (i < stages.length && stages[i] == stage) {
                curStagePlayer++;
                i++;
            }
            
            // 실패율 계산
            failures[stage - 1] = (float)curStagePlayer / playerCnt;
            playerCnt -= curStagePlayer;
            stage++;
        }
        
        // 실패율 내림차순 & 같으면 스테이지 번호로 오름차순
        return IntStream.range(0, N)
            .boxed()
            .sorted((s1, s2) -> Float.compare(failures[s2], failures[s1]))
            .mapToInt(i -> i + 1)
            .toArray();
    }
}