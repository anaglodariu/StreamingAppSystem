public class AddCommand extends Commands {
    @Override
    public <T1, T2> void executeCommand(T1 param1, T2 param2) {
        if (param2 == null && param1 instanceof Stream)
            StreamingApp.getInstance().addStream((Stream) param1);
    }
}
