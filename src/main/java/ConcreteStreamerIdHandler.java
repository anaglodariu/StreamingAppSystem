import java.util.Map;
import java.util.Objects;

public class ConcreteStreamerIdHandler implements ListRequestHandler {
    private ListRequestHandler nextHandler;
    public ListRequestHandler setNextHandler(ListRequestHandler listRequestHandler) {
        this.nextHandler = listRequestHandler;
        return nextHandler;
    }
    public void handle(Request request) {
        if (verify(request.id) != null) {
            Streamer streamer = verify(request.id);
            int count = countStreams(streamer);
            System.out.print("[");
            for (Map.Entry<Integer, Stream> entry : StreamingApp.getInstance().getStreamsMap().entrySet()) {
                if (Objects.equals(entry.getValue().getStreamerId(), streamer.getId())) {
                    count--;
                    if (count == 0)
                        System.out.print(entry.getValue());
                    else
                        System.out.print(entry.getValue() + ",");
                }
            }
            System.out.println("]");
        } else if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    public Streamer verify(Integer id) {
        StreamingApp streamingApp = StreamingApp.getInstance();
        return streamingApp.findStreamer(id);
    }

    public int countStreams(Streamer streamer) {
        int count = 0;
        for (Map.Entry<Integer, Stream> entry : StreamingApp.getInstance().getStreamsMap().entrySet()) {
            if (Objects.equals(entry.getValue().getStreamerId(), streamer.getId())) {
                count++;
            }
        }
        return count;
    }
}
