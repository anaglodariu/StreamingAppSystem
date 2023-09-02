import java.time.*;
import java.time.format.DateTimeFormatter;

public class Stream {
    private Integer streamType;
    private Integer id;
    private Integer streamGenre;
    private Long noOfStreams;
    private Integer streamerId;
    private Long length;
    private Long dateAdded;
    private String name;

    public Stream(Integer streamType, Integer id, Integer streamGenre, Long noOfStreams, Integer streamerId, Long length, Long dateAdded, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
    }

    public Integer getStreamType() {
        return streamType;
    }
    public Integer getId() {
        return id;
    }
    public Integer getStreamGenre() {
        return streamGenre;
    }
    public Long getNoOfStreams() {
        return noOfStreams;
    }
    public Integer getStreamerId() {
        return streamerId;
    }
    public Long getLength() {
        return length;
    }
    public Long getDateAdded() {
        return dateAdded;
    }
    public String getName() {
        return name;
    }
    public void increaseNoOfStreams() {
        this.noOfStreams = noOfStreams + 1;
    }
    public String getStreamerName() {
        /*afla numele streamer-ului*/
        StreamersFactory streamersFactory = StreamersFactory.getInstance();
        return streamersFactory.getStreamerName(streamerId, streamType);
    }
    public String getLengthInFormat() {
        long seconds = length;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        if (hours == 0)
            return String.format("%02d:%02d", minutes, seconds);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public String getDateAddedInFormat() {
        Instant instant = Instant.ofEpochSecond(dateAdded);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("GMT"));
        return zonedDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"streamerName\":\"" + getStreamerName() +
                "\",\"noOfListenings\":\"" + noOfStreams + "\",\"length\":\"" + getLengthInFormat() + "\",\"dateAdded\":\"" +
                getDateAddedInFormat() + "\"}";
    }


}
