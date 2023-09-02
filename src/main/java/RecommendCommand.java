import java.util.*;

public class RecommendCommand extends Commands {
    @Override
    public <T1, T2> void executeCommand(T1 param1, T2 param2) {
        if (param1 instanceof Integer && param2 instanceof Integer) {
            /*retin ce streameri asculta userul dupa id*/
            List<Integer> streamerslist = new ArrayList<>();
            List<Integer> streamsId = StreamingApp.getInstance().getUsersMap().get((Integer) param1).getStreams();
            for (Integer streamId : streamsId) {
                Stream stream = StreamingApp.getInstance().getStreamsMap().get(streamId);
                if (Objects.equals(stream.getStreamType(), param2)) {
                    streamerslist.add(stream.getStreamerId());
                }
            }
            /*retin toate streamurile cantate de acei streameri dupa id*/
            List<Integer> streamsList = getAllStreams(streamerslist);
            /*dupa pastrez doar streamurile neascultate de user*/
            streamsList.removeAll(streamsId);
            /*adaug streamurile dupa numarul de ascultari intr-un TreeSet*/
            SortedSet<Stream> sortedStreams = new TreeSet<>((o1, o2) -> {
                if (o1.getNoOfStreams() > o2.getNoOfStreams()) {
                    return -1;
                } else if (o1.getNoOfStreams() < o2.getNoOfStreams()) {
                    return 1;
                } else {
                    return 0;
                }
            });
            int count = 0;
            for (Integer streamId : streamsList) {
                sortedStreams.add(StreamingApp.getInstance().getStreamsMap().get(streamId));
                count++;
            }
            /*afisez doar primele 5 streamuri din TreeSet*/
            int count1 = 0;
            System.out.print("[");
            for (Stream stream : sortedStreams) {
                count--;
                count1++;
                if (count == 0 || count1 == 5) {
                    System.out.print(stream);
                    break;
                } else {
                    System.out.print(stream + ",");
                }
            }
            System.out.println("]");
        }
    }

    private List<Integer> getAllStreams(List<Integer> streamerslist) {
        List<Integer> streamsList = new ArrayList<>();
        for (Integer streamerId : streamerslist) {
            for (Map.Entry<Integer, Stream> entry : StreamingApp.getInstance().getStreamsMap().entrySet()) {
                if (Objects.equals(entry.getValue().getStreamerId(), streamerId)) {
                    streamsList.add(entry.getKey());
                }
            }
        }
        return streamsList;
    }
}
