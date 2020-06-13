package com.destroyyouth.personsandhobbies.aspects;

import java.util.NoSuchElementException;

import com.destroyyouth.personsandhobbies.commons.dtos.ErrorTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* com.destroyyouth.personsandhobbies.web.*.*(..))  && args(..)")
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {

        ResponseEntity result;

        try {

            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;

        } catch (NoSuchElementException e) {

            errorLog(e, joinPoint);
            ErrorTO error = new ErrorTO();
            error.setCode(HttpStatus.NOT_FOUND.value());
            error.setMessage(e.getMessage());
            result = new ResponseEntity(error, HttpStatus.NOT_FOUND);
            return result;

        } catch (IllegalArgumentException e) {

            errorLog(e, joinPoint);
            ErrorTO error = new ErrorTO();
            error.setCode(HttpStatus.BAD_REQUEST.value());
            error.setMessage("Uno de los argumentos no es del tipo requerido.");
            result = new ResponseEntity(error, HttpStatus.BAD_REQUEST);
            return result;

        } catch (Throwable e) {

            errorLog(e, joinPoint);

            ErrorTO error = new ErrorTO();
            error.setCode(HttpStatus.NOT_FOUND.value());
            error.setMessage(e.getMessage());
            result = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            return result;

        }

    }

    private void errorLog(Throwable e, ProceedingJoinPoint joinPoint) {
        LOG.info("Exception Ocurred");
        LOG.info("Execution: {}", joinPoint.getSignature());
        LOG.info("Exception: {}", e.getMessage());
    }
}
