public class ListRequest {
    /*clasa care se ocupa cu request-ul cerut:
    * de a lista streamuri*/
    private ListRequestHandler chain;
    public ListRequest() {
        buildChain();
    }
    private void buildChain() {
        /*fiecare handler din chain incearca pe rand sa rezolve
        * request-ul, daca primul nu reuseste, request-ul e
        * trimis la al doilea handler*/
        chain = new ConcreteStreamerIdHandler();
        chain.setNextHandler(new ConcreteUserIdHandler());
    }
    public void execute(Request request) {
        chain.handle(request);
    }
}
