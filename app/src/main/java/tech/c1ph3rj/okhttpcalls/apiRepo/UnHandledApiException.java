package tech.c1ph3rj.okhttpcalls.apiRepo;

public class UnHandledApiException extends Exception{
    public UnHandledApiException(String exceptionMsg) {
        super((exceptionMsg != null && !exceptionMsg.trim().isEmpty() && !exceptionMsg.contains("null") ? exceptionMsg : "Something Went Wrong!"));
    }

    public UnHandledApiException() {
        super("Something Went Wrong!");
    }
}
