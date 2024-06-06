package snakegame.second;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HighscoresPanel extends JPanel {

    static int num = 15; //num of scores
    JPanel[] panelHolder = new JPanel[num];

    public static final Comparator<Map.Entry<String,Integer>> comp = (e1, e2) -> {
        if(e2.getValue()==e1.getValue()) return e1.getKey().compareTo(e2.getKey());
        else return e2.getValue().compareTo(e1.getValue());
    };

    static TreeMap<String, Integer> scoreMap = new TreeMap<String,Integer>();
    static SortedSet<Map.Entry<String,Integer>> sortedSet = new TreeSet<Map.Entry<String, Integer>>(comp);

    public HighscoresPanel() {
        setLayout(new GridLayout(num, 1, 4, 2));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        scoreMap = new TreeMap<>();
        scoreMap.putAll(ScoreFileManager.loadScores(ScoreFileManager.scoreFilePath));
        sortedSet.addAll(scoreMap.entrySet());

        for(int i=0; i<num; i++){
            panelHolder[i] = new JPanel();
            panelHolder[i].setLayout(new GridLayout(1, 2));
            add(panelHolder[i]);
        }

        int j=0;
        for(Map.Entry<String,Integer> entry : sortedSet){
            if(j<15 && j<sortedSet.size()){
//                System.out.println(entry.toString());
                panelHolder[j].setBorder(new RoundBorder(10));
                panelHolder[j].add(new JLabel(entry.getKey(), SwingConstants.LEFT));
                panelHolder[j].add(new JLabel(String.valueOf(entry.getValue()), SwingConstants.RIGHT));
                j++;
            }
        }
    }

    public static void setNum(int num) {
        HighscoresPanel.num = num;
    }


}
