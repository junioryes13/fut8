package br.com.fut8.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class Fut8ExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    private final Logger logger = LoggerFactory.getLogger(Fut8ExceptionHandler.class);

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Erros> handleResponseStatusException(ResponseStatusException ex) {

        logger.warn("Mensagem: " + ex.getMessage() + "\nCausa: " + ex.getReason());
        return ResponseEntity.status(ex.getStatus())
                .body(new Erros(LocalDateTime.now(), ex.getStatus().value(), ex.getStatus().toString(), ex.getReason()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationFieldsError> handleMethodArgumentNotValidException(MethodArgumentNotValidException
                                                                                     exception) {
        List<ValidationFieldsError> listValidationFieldsError = new ArrayList<>();

        List<FieldError> listFieldErrors = exception.getBindingResult().getFieldErrors();

        listFieldErrors.forEach(fieldError -> {
            String messageContext = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

            ValidationFieldsError validationFieldsError = new ValidationFieldsError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(),
                    exception.getClass().toString(), fieldError.getField(), messageContext);

            listValidationFieldsError.add(validationFieldsError);
        });
        return listValidationFieldsError;
    }


}
