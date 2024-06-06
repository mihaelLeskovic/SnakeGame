package snakegame.second;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class ScoreFileManager {
    static Path workingDir = Path.of(System.getProperty("user.dir"));
    static Path scoreFilePath = workingDir.resolve("SnakeGameScores.txt");

    static void scoreSaver(){
//        System.out.println("attempting to save");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(scoreFilePath.toFile()))){
            for(Map.Entry<String,Integer> entry : HighscoresPanel.sortedSet){
//                System.out.println("zapis " +entry.toString());
                bw.write(entry.getKey());
                bw.write("-");
                bw.write(entry.getValue().toString());
                bw.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static TreeMap<String, Integer> loadScores(Path pathOfFile){
        TreeMap<String, Integer> scores = DefaultHighscores.getScores();
        if(scoreFilePath.toFile().exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(pathOfFile.toFile()))) {
                String line = br.readLine();
                while (line != null) {
//                    System.out.println(line.split("\t").length);
//                    System.out.println(line);
                    String[] data = new String[2];
                    data = line.split("-");
                    scores.put(data[0], Integer.parseInt(data[1]));
                    line = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return scores;
    }
}
