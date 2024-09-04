package puma.hope.librarian_users.exception;

public class ErrorResponseCustom {
    private final String error;

    public ErrorResponseCustom(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
