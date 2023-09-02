public class ProiectPOO {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
        } else {
            /*clasa StreamingApp e ca un manager al aplicatiei
            * in care retin streameri, stream-uri si useri*/
            StreamingApp streamingApp = StreamingApp.getInstance();
            streamingApp.instantiateMaps();

            ReadFromFiles readFromFiles = new ReadFromFiles(args[0], args[1], args[2]);
            readFromFiles.readStreamerCSV();
            readFromFiles.readUserCSV();
            readFromFiles.readStreamCSV();

            Commands.readCommands(args[3]);

            streamingApp.cleanUp();
            StreamersFactory.getInstance().cleanUp();
        }
    }
}
