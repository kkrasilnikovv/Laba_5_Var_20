import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Reader {
    String inputFileName = "resourse\\text.txt";
    ArrayList<Integer> times=new ArrayList<>();
    ArrayList<String> lines =new ArrayList<>();
    public void readingFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\$");
                lines.add(words[0]);
                times.add(Integer.parseInt(words[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lines.size()==times.size()){
            for(int i=0;i<lines.size();i++){
                try {
                    TimeUnit.SECONDS.sleep(times.get(i));
                } catch(InterruptedException e) {
                }
                System.out.println(lines.get(i));
            }
        }
        else{
            System.out.println("Нарушен специальный формат фокумента");
        }

    }
}
