package com.cseiu.passnet.saga.recruitmentsaga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RecruitmentSagaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentSagaApplication.class, args);
    }
}
