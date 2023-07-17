import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int min;
        final int playersLength = players.length;
        String[] answer = new String[playersLength];
        HashMap<String, Integer> playersRank = new HashMap<>();
        HashMap<String, Entry<String, String>> threePlayers = new HashMap<>();

        playersRank.put(players[0], playersLength - 1);
        threePlayers.put(players[0], new HashMap.SimpleEntry<>("", players[1]));
        for (int i = 1; i < playersLength - 1; i++) {
            playersRank.put(players[i], playersLength - (i + 1));
            threePlayers.put(players[i], new HashMap.SimpleEntry<>(players[i - 1], players[i + 1]));
        }
        playersRank.put(players[playersLength - 1], 0);
        threePlayers.put(players[playersLength - 1], new HashMap.SimpleEntry<>(players[playersLength - 2], ""));
        
        for (int i = 0; i < callings.length; i++) {
            String previousPlayer = threePlayers.get(callings[i]).getKey();
            String previousPlayer2 = threePlayers.get(previousPlayer).getKey();
            String nextPlayer = threePlayers.get(callings[i]).getValue();
            
            playersRank.put(callings[i], playersRank.get(callings[i]) + 1);
            playersRank.put(previousPlayer, playersRank.get(previousPlayer) - 1);
            
            if (!previousPlayer2.equals(""))
                threePlayers.put(previousPlayer2
                                 , new HashMap.SimpleEntry<>(threePlayers.get(previousPlayer2).getKey(), callings[i]));
            String tempPreviousPlayerKey = threePlayers.get(previousPlayer).getKey();
            threePlayers.put(previousPlayer, new HashMap.SimpleEntry<>(callings[i], nextPlayer));
            threePlayers.put(callings[i], new HashMap.SimpleEntry<>(tempPreviousPlayerKey, previousPlayer));
            if (!nextPlayer.equals(""))
                threePlayers.put(nextPlayer, new HashMap.SimpleEntry<>(previousPlayer, threePlayers.get(nextPlayer).getValue()));
        }
        
        min = Collections.min(playersRank.values());

        playersRank.forEach((key, value) -> {
            answer[playersLength - (value - min + 1)] = key;
        });
        
        return answer;
    }
}