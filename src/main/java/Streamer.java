public abstract class Streamer {
    protected Integer streamerType;
    protected Integer id;
    protected String name;

    public Streamer(Integer streamerType, Integer id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }

    public Integer getStreamerType() {
        return streamerType;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
