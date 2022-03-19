package overwatchutility.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private final Logger logger;

    public LoggingAdvice() {
        this.logger = LoggerFactory.getLogger(getClass());
    }
}