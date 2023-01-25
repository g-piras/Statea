package its.statea.webserver.web.common.controller.error;

import org.apache.http.HttpException;
import org.springframework.http.HttpStatus;

public class MyHttpException extends HttpException {

    private final HttpStatus status;

    public MyHttpException(HttpStatus status, String message) {
        
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}