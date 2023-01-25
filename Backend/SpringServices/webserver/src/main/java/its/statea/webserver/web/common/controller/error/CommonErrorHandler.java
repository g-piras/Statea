package its.statea.webserver.web.common.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CommonErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyHttpException.class)
    public ResponseEntity<Object> handleCustomExceptions(MyHttpException ex, WebRequest request) {

        HttpStatus status = ex.getStatus();
		String defaultDetail = ex.getMessage();
		ProblemDetail body = createProblemDetail(ex, status, defaultDetail, null, null, request);

		return handleExceptionInternal(ex, body, HttpHeaders.EMPTY, status, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleRequestValidationExceptions(ConstraintViolationException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        String defaultDetail = ex.getMessage();
		ProblemDetail body = createProblemDetail(ex, status, defaultDetail, null, null, request);

		return handleExceptionInternal(ex, body, HttpHeaders.EMPTY, status, request);
    }
}