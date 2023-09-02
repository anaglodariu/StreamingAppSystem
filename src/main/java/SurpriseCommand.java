import java.util.*;

public class SurpriseCommand extends Commands{
    @Override
    public <T1, T2> void executeCommand(T1 param1, T2 param2) {
        if (param1 instanceof Integer && param2 instanceof Integer) {
            /*retin streamerii ascultati de user dupa id*/
            List<Integer> streamerslist = new ArrayList<>();
            List<Integer> streamsId = StreamingApp.getInstance().getUsersMap().get((Integer) param1).getStreams();
            for (Integer streamId : streamsId) {
                Stream stream = StreamingApp.getInstance().getStreamsMap().get(streamId);
                if (Objects.equals(stream.getStreamType(), param2)) {
                    streamerslist.add(stream.getStreamerId());
                }
            }
            /*retin toti streamerii din aplicatie de un anumit tip dupa id*/
            List<Integer> fullStreamerslist = getAllStreamers(param2);
            /*pastrez doar pe cei pe care user-ul nu i-a ascultat inca dupa id*/
            fullStreamerslist.removeAll(streamerslist);
            /*adaug streamurile dupa data si numarul de ascultari intr-un TreeSet*/
            SortedSet<Stream> sortedStreams = new TreeSet<>((o1, o2) -> {
                if (o1.getDateAdded() > o2.getDateAdded()) {
                    return -1;
                } else if (o1.getDateAdded() < o2.getDateAdded()) {
                    return 1;
                } else {
                    return o2.getNoOfStreams().compareTo(o1.getNoOfStreams());
                }
            });
            int count  = 0;
            for (Integer streamerId : fullStreamerslist) {
                for (Map.Entry<Integer, Stream> entry : StreamingApp.getInstance().getStreamsMap().entrySet()) {
                    if (Objects.equals(entry.getValue().getStreamerId(), streamerId)) {
                        sortedStreams.add(entry.getValue());
                        count++;
                    }
                }
            }
            /*afisez doar primele 3 streamuri din TreeSet*/
            int count1 = 0;
            System.out.print("[");
            for (Stream stream : sortedStreams) {
                count--;
                count1++;
                if (count == 0 || count1 == 3) {
                    System.out.print(stream);
                    break;
                } else {
                    System.out.print(stream + ",");
                }
            }
            System.out.println("]");
        }
    }

    private <T2> List<Integer> getAllStreamers(T2 param2) {
        List<Integer> fullStreamerslist = new ArrayList<>();
        if (param2.equals(1)) {
            for (Map.Entry<Integer, Musician> entry : StreamingApp.getInstance().getMusiciansMap().entrySet()) {
                fullStreamerslist.add(entry.getKey());
            }
        } else if (param2.equals(2)) {
            for (Map.Entry<Integer, Podcaster> entry : StreamingApp.getInstance().getPodcastersMap().entrySet()) {
                fullStreamerslist.add(entry.getKey());
            }
        } else if (param2.equals(3)) {
            for (Map.Entry<Integer, AuthorAudioBook> entry : StreamingApp.getInstance().getAuthorsMap().entrySet()) {
                fullStreamerslist.add(entry.getKey());
            }
        }
        return fullStreamerslist;
    }
}
