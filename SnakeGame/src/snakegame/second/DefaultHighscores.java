package snakegame.second;

import java.util.TreeMap;

public class DefaultHighscores {
    static TreeMap<String, Integer> getScores(){
        TreeMap<String,Integer> defaultMap = new TreeMap<>();

        defaultMap.put("nikoo", 50);
        defaultMap.put("murvey", 47);
        defaultMap.put("dunj", 43);
        defaultMap.put("mih", 38);
        defaultMap.put("kristian", 33);
        defaultMap.put("sopa", 28);
        defaultMap.put("baka", 13);

        return defaultMap;
    }
}
