package api;

public record ApiError(int status, String code, String description) {
}
