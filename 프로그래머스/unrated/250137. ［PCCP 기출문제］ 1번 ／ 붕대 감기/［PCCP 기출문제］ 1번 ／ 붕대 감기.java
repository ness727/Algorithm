class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int count = 0;
        int max = health;
        
        for (int i = 0; i < attacks.length;) {
            if (time == attacks[i][0]) {
                health -= attacks[i][1];
                count = 0;
                i++;
            }
            else {
                health += bandage[1];
                count++;
                if (count == bandage[0]) {
                    health += bandage[2];
                    count = 0;
                }
                if (health > max) health = max;
            }
            time++;
            if (health <= 0) return -1;
        }
        return health > 0 ? health : -1;
    }
}