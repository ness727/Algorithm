import java.util.stream.Collectors;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Plan> planList = new ArrayList<>();
        ArrayList<Plan> stoppedPlanList = new ArrayList<>();
        int plansRemainTime = 0;
        
        for (String[] p : plans) planList.add(new Plan(p));
        planList = planList.stream()  // 시작 시간 순서대로 정렬
            .sorted((p1, p2) -> p1.getTime() - p2.getTime())
            .collect(Collectors.toCollection(ArrayList::new));
        
        for (int i = 0; i < plans.length; i++) {
            // 멈춘 과제가 있을 때
            if (stoppedPlanList.size() > 0 && plansRemainTime > 0) {
                for (int j = stoppedPlanList.size() - 1; j >= 0; j--) {
                    Plan stPlan = stoppedPlanList.get(j);
                    // 시간 안에 남은 한 과제를 할 수 있을 때
                    if (stPlan.getRemainTime() < plansRemainTime) {
                        plansRemainTime -= stPlan.getRemainTime();
                        result.add(stPlan.getName());
                        stoppedPlanList.remove(stPlan);
                    }
                    //  시간에 딱 맞춰서 남은 한 과제를 완료했을 때
                    else if (stPlan.getRemainTime() == plansRemainTime) {
                        result.add(stPlan.getName());
                        stoppedPlanList.remove(stPlan);
                        break;
                    }
                    else {  // 시간이 부족해서 남은 한 과제를 다 못 했을 때
                        stPlan.setRemainTime(stPlan.getRemainTime() - plansRemainTime);
                        break;
                    }
                }
            }
            
            if (i == plans.length - 1) break;
            
            plansRemainTime = 0;
            Plan currentPlan = planList.get(i);
            Plan nextPlan = planList.get(i + 1);
                
            //  다음 과제 시간 전에 마쳤을 때
            if (currentPlan.getTime() + currentPlan.getRemainTime() < nextPlan.getTime()) {
                result.add(currentPlan.getName());
                plansRemainTime = nextPlan.getTime() - (currentPlan.getTime() + currentPlan.getRemainTime());
            }
            //  다음 과제 시간에 딱 맞췄을 때
            else if (currentPlan.getTime() + currentPlan.getRemainTime() == nextPlan.getTime()) {
                result.add(currentPlan.getName());
            }
            else {  // 시간을 맞추지 못 해 해당 과제를 멈춘 과제로 이동
                currentPlan.setRemainTime(currentPlan.getRemainTime() 
                                          - (nextPlan.getTime() - currentPlan.getTime()));
                stoppedPlanList.add(currentPlan);
            }
        }
        result.add(planList.get(planList.size() - 1).getName());
        for (int j = stoppedPlanList.size() - 1; j >= 0; j--) result.add(stoppedPlanList.get(j).getName());
        return result.toArray(String[]::new);
    }
    
    public class Plan {
        private String name;
        private int time;
        private int remainTime;
    
        public Plan(String[] plan) {
            name = plan[0];
            time = Integer.valueOf(plan[1].substring(0, 2)) * 60
                    + Integer.valueOf(plan[1].substring(3, 5));
            remainTime = Integer.valueOf(plan[2]);
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getTime() {
            return time;
        }
    
        public void setTime(int time) {
            this.time = time;
        }
    
        public int getRemainTime() {
            return remainTime;
        }
    
        public void setRemainTime(int remainTime) {
            this.remainTime = remainTime;
        }
    }
}