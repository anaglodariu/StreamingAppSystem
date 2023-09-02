public class StreamersFactory {
    /*am folosit Factory design pattern*/
    private static StreamersFactory uniqueInstanceStreamersFactory = null;
    private StreamersFactory() {
    }
    public static StreamersFactory getInstance() {
        if (uniqueInstanceStreamersFactory == null)
            uniqueInstanceStreamersFactory = new StreamersFactory();
        return uniqueInstanceStreamersFactory;
    }
    public Streamer createStreamer(Integer streamerType, Integer id, String name) {
        if (streamerType.intValue() == 1) {
            return new Musician(streamerType, id, name);
        } else if (streamerType.intValue() == 2) {
            return new Podcaster(streamerType, id, name);
        } else if (streamerType.intValue() == 3) {
            return new AuthorAudioBook(streamerType, id, name);
        } else {
            return null;
        }
    }

    public void addStreamer(Streamer streamer) {
        /*retin streamerii de fiecare tip in cate un hashmap diferit*/
        StreamingApp streamingApp = StreamingApp.getInstance();
        if (streamer.getStreamerType().intValue() == 1) {
            streamingApp.addMusician((Musician) streamer);
        } else if (streamer.getStreamerType().intValue() == 2) {
            streamingApp.addPodcaster((Podcaster) streamer);
        } else if (streamer.getStreamerType().intValue() == 3) {
            streamingApp.addAuthor((AuthorAudioBook) streamer);
        }
    }

    public String getStreamerName(Integer id, Integer streamerType) {
        StreamingApp streamingApp = StreamingApp.getInstance();
        if (streamerType.intValue() == 1) {
            return streamingApp.getMusiciansMap().get(id).getName();
        } else if (streamerType.intValue() == 2) {
            return streamingApp.getPodcastersMap().get(id).getName();
        } else if (streamerType.intValue() == 3) {
            return streamingApp.getAuthorsMap().get(id).getName();
        } else {
            return null;
        }
    }

    public void cleanUp() {
        uniqueInstanceStreamersFactory = null;
    }
}
