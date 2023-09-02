import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFiles {
    private String streamersFile;
    private String usersFile;
    private String streamsFile;
    static String path = "src/main/resources/";

    public ReadFromFiles(String streamersFile, String streamsFile, String usersFile) {
        this.streamersFile = streamersFile;
        this.usersFile = usersFile;
        this.streamsFile = streamsFile;
    }
    public void readStreamerCSV() {
        try {
            /*fac clasa StreamersFactory de tip Singleton si ma folosesc de instanta unica
            * pentru a crea streameri*/
            StreamersFactory streamersFactory = StreamersFactory.getInstance();
            FileReader filereader = new FileReader(path + streamersFile);
            CSVReader csvReader = new CSVReader(filereader);
            String[] line = csvReader.readNext();
            if (line == null) {
                System.out.println("File is empty");
            }
            while((line = csvReader.readNext()) != null) {
                Streamer streamer = streamersFactory.createStreamer(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]);
                /*creez un streamer si il adaug in map*/
                streamersFactory.addStreamer(streamer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | CsvValidationException e) {
            System.out.println("readNext() failed");
        }
    }

    public void readUserCSV() {
        try {
            FileReader filereader = new FileReader(path + usersFile);
            CSVReader csvReader = new CSVReader(filereader);
            String[] line = csvReader.readNext();
            if (line == null) {
                System.out.println("File is empty");
            }
            while((line = csvReader.readNext()) != null) {
                List<Integer> streamsId = new ArrayList<>();
                String[] streams = line[2].split(" ");
                for (String stream : streams) {
                    streamsId.add(Integer.parseInt(stream));
                }
                User user = new User(Integer.parseInt(line[0]), line[1], streamsId);
                StreamingApp streamingApp = StreamingApp.getInstance();
                /*creez un user si il adaug in map*/
                streamingApp.addUser(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | CsvValidationException e) {
            System.out.println("readNext() failed");
        }
    }

    public void readStreamCSV() {
        try {
            FileReader filereader = new FileReader(path + streamsFile);
            CSVReader csvReader = new CSVReader(filereader);
            String[] line = csvReader.readNext();
            if (line == null) {
                System.out.println("File is empty");
            }
            while((line = csvReader.readNext()) != null) {
                Stream stream = new Stream(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Long.parseLong(line[3]),
                        Integer.parseInt(line[4]), Long.parseLong(line[5]), Long.parseLong(line[6]), line[7]);
                StreamingApp streamingApp = StreamingApp.getInstance();
                /*creez un stream si il adaug in map*/
                streamingApp.addStream(stream);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | CsvValidationException e) {
            System.out.println("readNext() failed");
        }
    }
}
