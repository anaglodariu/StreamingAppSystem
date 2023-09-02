public class DeleteCommand extends Commands {
    @Override
    public <T1, T2> void executeCommand(T1 param1, T2 param2) {
        if (param1 instanceof Integer && param2 instanceof Integer) {
            StreamingApp.getInstance().getStreamsMap().remove(param1);
        }
    }
}
