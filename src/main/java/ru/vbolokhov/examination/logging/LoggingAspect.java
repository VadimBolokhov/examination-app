package ru.vbolokhov.examination.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Aspect for logging.
 * @author Vadim Bolokhov
 */
@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Around("@annotation(ru.vbolokhov.examination.annotation.Loggable)")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        int items = this.getItemsNumber(result);
        this.logger.info(
                "Invocation of {}, received {} items.",
                joinPoint.getSignature().getName(),
                items
        );
        return result;
    }

    private int getItemsNumber(Object object) {
        return object == null ? 0 : this.getCollectionSize(object);
    }

    private int getCollectionSize(Object object) {
        return object instanceof Collection ? ((Collection) object).size() : 1;
    }
}
