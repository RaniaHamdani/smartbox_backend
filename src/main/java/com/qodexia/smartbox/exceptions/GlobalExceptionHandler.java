package com.qodexia.smartbox.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.NoRouteToHostException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice

public class GlobalExceptionHandler implements ProblemHandling {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final HttpStatus badRequest = HttpStatus.BAD_REQUEST;


    @ExceptionHandler(value = {RessourceNotFoundException.class})
    public ResponseEntity handleRessourceNotFoundException(RessourceNotFoundException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                e.getStatus(),
                ZonedDateTime.now());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }


    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException e,
            final NativeWebRequest request) {
        BindingResult result = e.getBindingResult();
        List<FieldsErrorModel> fieldErrors = new ArrayList<>();
        result.getFieldErrors().stream().forEach(
                fieldError -> {
                    FieldsErrorModel fieldsErrorModel = new FieldsErrorModel(
                            fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                    fieldErrors.add(fieldsErrorModel);
                }
        );
        Problem problem = Problem.builder().withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE).
                withStatus(defaultConstraintViolationStatus()).withTitle("Method argument not valid")
                .with("message", ErrorConstants.ERR_VALIDATION).
                        with("field errors", fieldErrors).build();
        return create(e, problem, request);
    }

    @ExceptionHandler(value = {NotMatchPasswordException.class})
    public ResponseEntity handleNotMatchPasswordException(NotMatchPasswordException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                e.getStatus(),
                ZonedDateTime.now());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }

    @ExceptionHandler(value = {NullRoleException.class})
    public ResponseEntity handleNullRoleException(NotMatchPasswordException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                e.getStatus(),
                ZonedDateTime.now());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity handleBadRequestException(BadRequestException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                e.getStatus(),
                ZonedDateTime.now());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }

//    @Override
//    public ResponseEntity<Problem> handleConstraintViolation(
//            final ConstraintViolationException e,
//            final NativeWebRequest request) {
//        List<String> messages = new ArrayList<>();
//        e.getConstraintViolations().stream().map(
//                constraintViolation -> messages.add(constraintViolation.getMessage())
//        );
//        Problem problem = Problem.builder().withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE).
//                withStatus(defaultConstraintViolationStatus()).withTitle("Method argument not valid")
//                .with("message", ErrorConstants.ERR_VALIDATION).
//                        with("errors messages", messages).build();
//        return create(e, problem, request);
//    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity handleHibernateConstraintViolation(ConstraintViolationException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                ZonedDateTime.now(),
                e.getConstraintName());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }


    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity handleBAdCredentialException(BadCredentialsException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                ZonedDateTime.now(),
                e.getCause().getMessage()
        );
        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity handlePSQLException(DataIntegrityViolationException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add(e.getCause().getCause().getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                ZonedDateTime.now(),
                e.getCause().getCause().getMessage());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }

    @ExceptionHandler(value = {NoRouteToHostException.class})
    public ResponseEntity noRouteExceptionHandler(NoRouteToHostException e) {
        List<String> messageList = new ArrayList<>();
        messageList.add("mail ne peut pas être envoyer");
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                messageList,
                ZonedDateTime.now(),
                e.getCause().getMessage());

        return new ResponseEntity<>(
                exceptionDTO,
                badRequest
        );
    }


//    @Override
//    public ResponseEntity handleAuthentication(final AuthenticationException e,
//                                                 final NativeWebRequest request) {
//        List<String> messageList = new ArrayList<>();
//        messageList.add("mail ne peut pas être envoyer");
//        ExceptionDTO exceptionDTO = new ExceptionDTO(
//                messageList,
//                ZonedDateTime.now(),
//                e.getCause().getMessage());
//        return new ResponseEntity<>(
//                exceptionDTO,
//                badRequest
//        );
//    }

}
