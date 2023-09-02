public class ConcreteUserIdHandler implements ListRequestHandler {
    private ListRequestHandler nextHandler;
    public ListRequestHandler setNextHandler(ListRequestHandler listRequestHandler) {
        this.nextHandler = listRequestHandler;
        return nextHandler;
    }
    public void handle(Request request) {
        if (verify(request.id) != null) {
            User user = verify(request.id);
            int count = user.getStreams().size();
            System.out.print("[");
            for (Integer streamId : user.getStreams()) {
                Stream stream = StreamingApp.getInstance().getStreamsMap().get(streamId);
                count--;
                if (count == 0)
                    System.out.print(stream);
                else
                    System.out.print(stream + ",");
            }
            System.out.println("]");

        } else if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
    public User verify(Integer id) {
        StreamingApp streamingApp = StreamingApp.getInstance();
        return streamingApp.getUsersMap().get(id);
    }
}

