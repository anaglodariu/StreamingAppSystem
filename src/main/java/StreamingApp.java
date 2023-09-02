import java.util.LinkedHashMap;

public class StreamingApp {
    private static StreamingApp uniqueApp = null;
    private LinkedHashMap<Integer, User> usersMap;
    private LinkedHashMap<Integer, Musician> musiciansMap;
    private LinkedHashMap<Integer, Podcaster> podcastersMap;
    private LinkedHashMap<Integer, AuthorAudioBook> authorsMap;
    private LinkedHashMap<Integer, Stream> streamsMap;
    private static int contor = 0;

    private StreamingApp() {}

    public static StreamingApp getInstance() {
        if (uniqueApp == null) {
            uniqueApp = new StreamingApp();

        }
        return uniqueApp;
    }

    public void instantiateMaps() {
        if (contor == 0) {
            usersMap = new LinkedHashMap<>();
            musiciansMap = new LinkedHashMap<>();
            podcastersMap = new LinkedHashMap<>();
            authorsMap = new LinkedHashMap<>();
            streamsMap = new LinkedHashMap<>();
            contor++;
        }
    }

    public void addUser(User user) {
        usersMap.put(user.getId(), user);
    }

    public void addMusician(Musician musician) {
        musiciansMap.put(musician.getId(), musician);
    }

    public void addPodcaster(Podcaster podcaster) {
        podcastersMap.put(podcaster.getId(), podcaster);
    }

    public void addAuthor(AuthorAudioBook author) {
        authorsMap.put(author.getId(), author);
    }

    public void addStream(Stream stream) {
        streamsMap.put(stream.getId(), stream);
    }

    public LinkedHashMap<Integer, User> getUsersMap() {
        return usersMap;
    }
    public LinkedHashMap<Integer, Musician> getMusiciansMap() {
        return musiciansMap;
    }
    public LinkedHashMap<Integer, Podcaster> getPodcastersMap() {
        return podcastersMap;
    }
    public LinkedHashMap<Integer, AuthorAudioBook> getAuthorsMap() {
        return authorsMap;
    }
    public LinkedHashMap<Integer, Stream> getStreamsMap() {
        return streamsMap;
    }

    public Streamer findStreamer(Integer streamerId) {
        if (musiciansMap.containsKey(streamerId)) {
            return musiciansMap.get(streamerId);
        } else if (podcastersMap.containsKey(streamerId)) {
            return podcastersMap.get(streamerId);
        } else if (authorsMap.containsKey(streamerId)) {
            return authorsMap.get(streamerId);
        } else {
            return null;
        }
    }

    public void cleanUp() {
        uniqueApp = null;
        contor = 0;
    }
}
