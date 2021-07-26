package com.cseiu.sagaorganizer.common.aspects;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.sagaorganizer.common.exceptions.SagaNotFoundException;
import com.cseiu.sagaorganizer.common.models.SagaOrchestrator;
import com.cseiu.sagaorganizer.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j(topic = "[SagaAspect]")
public class SagaAspect {

    private final SagaStoreService sagaStoreService;

    @Autowired
    public SagaAspect(SagaStoreService sagaStoreService) {
        this.sagaStoreService = sagaStoreService;
    }

    @Pointcut("@annotation(com.cseiu.sagaorganizer.common.annotations.CleanupSaga)")
    void successSagaPointcut() {
    }

    @AfterReturning(value = "successSagaPointcut() && args(response)")
    void removeSagaAdvice(JoinPoint joinPoint, SuccessResponse response) {
        try {
            SagaOrchestrator orchestrator = sagaStoreService.findSaga(response.getEventId());
            if (orchestrator.isSuccess()) {
                log.info("all services success");
                sagaStoreService.removeSaga(response.getEventId());
            }
        } catch (SagaNotFoundException exception) {
            log.error("SagaNotFound: this service is not a producer for this event");
        }
    }
}