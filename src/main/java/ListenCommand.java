public class ListenCommand extends Commands{
    @Override
    public <T1, T2> void executeCommand(T1 param1, T2 param2) {
        if (param1 instanceof Integer && param2 instanceof Integer) {
            StreamingApp.getInstance().getUsersMap().get((Integer) param1).getStreams().add((Integer) param2);
            StreamingApp.getInstance().getStreamsMap().get(param2).increaseNoOfStreams();
        }
    }
}

