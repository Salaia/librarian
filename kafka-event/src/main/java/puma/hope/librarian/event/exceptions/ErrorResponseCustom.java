package puma.hope.librarian.event.exceptions;

public class ErrorResponseCustom {
    private final String error;

    public ErrorResponseCustom(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
