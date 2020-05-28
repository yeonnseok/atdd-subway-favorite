package wooteco.subway.web;

public class BusinessException extends RuntimeException {
    private final String errorCode;

    public BusinessException(final String errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
