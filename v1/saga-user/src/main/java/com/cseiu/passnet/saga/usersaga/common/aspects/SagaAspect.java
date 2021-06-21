package com.cseiu.passnet.saga.usersaga.common.aspects;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.usersaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.usersaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.usersaga.common.services.SagaStoreService;
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

    @Pointcut("@annotation(com.cseiu.passnet.saga.usersaga.common.annotations.CleanupSaga)")
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
