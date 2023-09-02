import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<Integer> streams;

    public User(Integer id, String name, List<Integer> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Integer> getStreams() {
        return streams;
    }

}
