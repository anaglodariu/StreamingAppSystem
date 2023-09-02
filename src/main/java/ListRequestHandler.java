interface ListRequestHandler {
    /*metodele care vor fi implementate de handleri*/
    ListRequestHandler setNextHandler(ListRequestHandler listRequestHandler);
    void handle(Request request);

}


