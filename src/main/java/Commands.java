import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Commands {
    /*pentru comenzi folosesc Command design pattern*/
    /*incapsulez comenzile citite din fisier ca obiect*/

    public abstract <T1, T2> void executeCommand(T1 param1, T2 param2);

    public static void readCommands(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(ReadFromFiles.path + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] command = line.split(" ");
                if (command[1].equals("LIST")) {
                    ListRequest listRequest = new ListRequest();
                    /*folosesc Chain of responsibility design pattern*/
                    /*evita cuplarea expeditorului unei cereri de destinatar, deci mai multe
                    * obiecte se pot ocupa de o anumita cerere*/
                    listRequest.execute(new Request(Integer.parseInt(command[0])));
                } else if (command[1].equals("ADD")) {
                    String name = command[6];
                    for (int i = 7; i < command.length; i++) {
                        name += " " + command[i];
                    }
                    long unixTime = System.currentTimeMillis() / 1000L;
                    Stream stream = new Stream(Integer.parseInt(command[2]), Integer.parseInt(command[3]), Integer.parseInt(command[2]), 0L,
                            Integer.parseInt(command[0]), Long.parseLong(command[5]), unixTime, name);
                    Commands addCommand = new AddCommand();
                    addCommand.executeCommand(stream, null);
                } else if (command[1].equals("DELETE")) {
                    Integer streamerId = Integer.parseInt(command[0]);
                    Integer streamId = Integer.parseInt(command[2]);
                    Commands deleteCommand = new DeleteCommand();
                    deleteCommand.executeCommand(streamId, streamerId);
                } else if (command[1].equals("LISTEN")) {
                    Integer userId = Integer.parseInt(command[0]);
                    Integer streamId = Integer.parseInt(command[2]);
                    Commands listenCommand = new ListenCommand();
                    listenCommand.executeCommand(userId, streamId);
                } else if (command[1].equals("RECOMMEND")) {
                    Integer userId = Integer.parseInt(command[0]);
                    Integer type;
                    if (command[2].equals("SONG")) {
                        type = 1;
                    } else if (command[2].equals("PODCAST")) {
                        type = 2;
                    } else {
                        type = 3;
                    }
                    Commands recommendCommand = new RecommendCommand();
                    recommendCommand.executeCommand(userId, type);
                } else if (command[1].equals("SURPRISE")) {
                    Integer userId = Integer.parseInt(command[0]);
                    Integer type;
                    if (command[2].equals("SONG")) {
                        type = 1;
                    } else if (command[2].equals("PODCAST")) {
                        type = 2;
                    } else {
                        type = 3;
                    }
                    Commands surpriseCommand = new SurpriseCommand();
                    surpriseCommand.executeCommand(userId, type);
                }
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
